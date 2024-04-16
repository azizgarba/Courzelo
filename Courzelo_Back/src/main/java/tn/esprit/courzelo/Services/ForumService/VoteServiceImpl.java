package tn.esprit.courzelo.Services.ForumService;

import lombok.AllArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import tn.esprit.courzelo.Repositories.ForumRepo.AnswerRepository;
import tn.esprit.courzelo.Repositories.ForumRepo.BadgeForumTeacherRepos;
import tn.esprit.courzelo.Repositories.ForumRepo.IncentivesRepo;
import tn.esprit.courzelo.Repositories.ForumRepo.VoteRepo;
import tn.esprit.courzelo.Repositories.UserRepo.UserRepository;
import tn.esprit.courzelo.entities.ForumEntities.Answer;
import tn.esprit.courzelo.entities.ForumEntities.BadgeForumTeacher;
import tn.esprit.courzelo.entities.ForumEntities.Incentives;
import tn.esprit.courzelo.entities.ForumEntities.Votes;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static tn.esprit.courzelo.entities.ForumEntities.IncentivesType.IncentiveExplanation;
import static tn.esprit.courzelo.entities.ForumEntities.IncentivesType.IncentiveVote;

@Service
@AllArgsConstructor
public class VoteServiceImpl {
    private  AnswerServiceImpl answerService ;
    private VoteRepo  voteRepository;
    private UserRepository userRepository;
    private AnswerRepository answerRepository;
    private IncentivesRepo incentivesRepo;
    private BadgeForumTeacherRepos badgeForumTeacheRepo;
    private SimpMessagingTemplate messagingTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(VoteServiceImpl.class);



    private void update_answer_nb_vote(int modifier, Votes vote) {
       int answer_vote = vote.getAnswer().getNbrVote();
        vote.getAnswer().setNbrVote( answer_vote + vote.getVoteType()* modifier);
        Answer updatedAnswer = answerService.updateVote(vote.getAnswer());

        if (updatedAnswer != null) {
            LOGGER.debug("Nombre de votes mis à jour pour la réponse : " + updatedAnswer);
        } else {
            LOGGER.debug("La mise à jour du nombre de votes pour la réponse a échoué.");
        }

    }
    public Votes add(Votes vote, String userId,String answerId) {

        UserCourzelo u = userRepository.findUserCourzeloById(userId);
        Answer a = answerRepository.findAnswerById(answerId);
          Date now= new Date();
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTime(now);


        if (u != null && a != null) {
            vote.setTeacher(u);
            vote.setAnswer(a);
            vote.setDate(now);
            Votes savedVote = voteRepository.save(vote);
            if(savedVote!=null) {
                // Mettre à jour le nombre de votes de la réponse associée
                this.update_answer_nb_vote(1, savedVote);
                u.setValidVoteCount(u.getValidVoteCount() + 1);
                vote.getTeacher().setNbVoteForIncentives(vote.getTeacher().getNbVoteForIncentives() + 1);
                if (u.getValidVoteCount() >= 5) {
                    u.setCanVote(false);
                    scheduleResetCanVote(u);
                    // this.resetCanVote(u);
                    //userRepo.save(u);
                    LOGGER.debug("vote *************" + u.getValidVoteCount());
                }
                Incentives ins = incentivesRepo.findFirstByTeacherAndIncentivesTypeOrderByDateOFObtainingDesc(u, IncentiveVote);

                if (ins == null && u.getNbVoteForIncentives() >= 5) {
                    Incentives ii = new Incentives();
                    ii.setTeacher(u);
                    ii.setIncentivesType(IncentiveVote);
                    ii.setDateOFObtaining(new Date());
                    int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                    int month = calendar.get(Calendar.MONTH); // Ajoutez 1 car les mois sont indexés à partir de 0
                    int year = calendar.get(Calendar.YEAR);
                    calendar.set(Calendar.DAY_OF_MONTH, u.getPaymentDay());
                    calendar.set(Calendar.YEAR, year);
                    if (dayOfMonth <= u.getPaymentDay()) {
                        calendar.set(Calendar.MONTH, month);
                        // Obtenez la date résultante
                        Date deliberationDate = calendar.getTime();
                        ii.setDeliberationDate(deliberationDate);
                        incentivesRepo.save(ii);
                        String notificationMessage = "New Incentive added to you it is an " + ii.getIncentivesType();

                        // Envoyer le message aux abonnés du sujet WebSocket
                        messagingTemplate.convertAndSend("/topic/primes", notificationMessage);
                        u.setNbVoteForIncentives(0);
                }} else {


                if (u.getNbVoteForIncentives() >= 5) {
                    //150
                    calendar2.setTime(ins.getDeliberationDate());
                    int month2 = calendar2.get(Calendar.MONTH);
                    Incentives i = new Incentives();
                    i.setTeacher(u);
                    i.setIncentivesType(IncentiveVote);
                    i.setDateOFObtaining(new Date());
                    int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                    int month = calendar.get(Calendar.MONTH); // Ajoutez 1 car les mois sont indexés à partir de 0
                    int year = calendar.get(Calendar.YEAR);
                    calendar.set(Calendar.DAY_OF_MONTH, u.getPaymentDay());
                    calendar.set(Calendar.YEAR, year);
                    if (dayOfMonth <= u.getPaymentDay()) {
                        calendar.set(Calendar.MONTH, month);
                        // Obtenez la date résultante
                        Date deliberationDate = calendar.getTime();
                        i.setDeliberationDate(deliberationDate);
                        incentivesRepo.save(i);
                        String notificationMessage = "New Incentive added to you it is an " + i.getIncentivesType();

                        // Envoyer le message aux abonnés du sujet WebSocket
                        messagingTemplate.convertAndSend("/topic/primes", notificationMessage);
                        u.setNbVoteForIncentives(0);
                        //List<Incentives> list= incentivesRepo.findIncentivesByOrderByDateOFObtainingDesc();

                        if ((month2 == (month - 1))) {
                            u.setNbPrimeVoteForBadges(u.getNbPrimeVoteForBadges() + 1);
                            if (u.getNbPrimeVoteForBadges() >= 5) {
                                List<Incentives> insVote = incentivesRepo.findFirst5ByTeacherAndIncentivesTypeOrderByDateOFObtainingDesc(u, IncentiveVote);
                                List<Incentives> insExp = incentivesRepo.findFirst5ByTeacherAndIncentivesTypeOrderByDateOFObtainingDesc(u, IncentiveExplanation);

                                if (!insVote.isEmpty()) {
                                    Date premiereDateObtention = insVote.get(0).getDateOFObtaining();
                                    Date derniereDateObtention = insVote.get(insVote.size() - 1).getDateOFObtaining();

                                    if (!insExp.isEmpty()) {
                                        Date date1Exp = insExp.get(0).getDateOFObtaining();
                                        Date date2Exp = insExp.get(insExp.size() - 1).getDateOFObtaining();

                                        if ((date1Exp.compareTo(premiereDateObtention) <= 0 && date1Exp.compareTo(derniereDateObtention) >= 0) &&
                                                (date2Exp.compareTo(premiereDateObtention) <= 0 && date2Exp.compareTo(derniereDateObtention) >= 0)) {
                                            System.out.println("date1Exp et date2Exp sont tous les deux entre premiereDateObtention et derniereDateObtention");
                                            // Obtient un badge
                                            BadgeForumTeacher badge = new BadgeForumTeacher();
                                            badge.setDate(now);
                                            badge.setTeacher(u);
                                            badgeForumTeacheRepo.save(badge);
                                            String notificationMessage2 = " Congratulations New Badge added to you ! ";

                                            // Envoyer le message aux abonnés du sujet WebSocket
                                            messagingTemplate.convertAndSend("/topic/primes", notificationMessage2);
                                            u.setNbPrimeVoteForBadges(0);
                                        } else {
                                            System.out.println("Au moins l'une des dates n'est pas entre premiereDateObtention et derniereDateObtention donc le prof n'obtient pas badge");
                                            u.setNbPrimeVoteForBadges(0);
                                        }
                                    } else {
                                        LOGGER.info("La liste des explications est vide.");
                                        u.setNbPrimeVoteForBadges(0);
                                    }
                                } else {
                                    LOGGER.info("La liste des votes est vide.");
                                }
                            } else {
                                LOGGER.info("Le nombre de votes primaires est insuffisant.");
                            }

                        } else {
                            u.setNbPrimeVoteForBadges(0);
                            LOGGER.info("un mois raté dans le vote  ");
                        }

                        LOGGER.info("incentive*************" + dayOfMonth);
                    } else {
                        calendar.set(Calendar.MONTH, month + 1);
                        Date deliberationDate = calendar.getTime();
                        i.setDeliberationDate(deliberationDate);
                        incentivesRepo.save(i);
                        u.setNbVoteForIncentives(0);
                        LOGGER.info("incentive*************333  " + month);
                        if ((month2 == (month + 1 - 2))) {
                            u.setNbPrimeVoteForBadges(u.getNbPrimeVoteForBadges() + 1);

                        } else {
                            u.setNbPrimeVoteForBadges(0);
                        }
                    }

                }
            }
                userRepository.save(u);
                return savedVote;
            }
            LOGGER.debug("vote est nulllllllllllllllllllllllll");
        }
         return null ;
    }

    private void scheduleResetCanVote(UserCourzelo u) {
        // Utilisez une tâche planifiée unique pour rétablir canVote à true après une minute supplémentaire
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                u.setCanVote(true);
                u.setValidVoteCount(0);
                userRepository.save(u); // Enregistrer la mise à jour dans la base de données
            }
        }, 60 * 1000); // Délai d'une minute en millisecondes  24 * 60 * 60 * 1000 apres24h
    }

    public Votes update(Votes votes) {
        Votes vote = voteRepository.findVotesById(votes.getId());

        if (vote != null) {
            // Mettre à jour les attributs de l'entité Vote avec les valeurs de l'objet votes
            // Assurez-vous de vérifier si chaque attribut est différent avant de le mettre à jour
            vote.setVoteType(votes.getVoteType()); // Exemple d'attribut à mettre à jour

            Votes savedVote = voteRepository.save(vote); // Enregistrer les modifications dans la base de données
            if (savedVote != null) {
                // Mettre à jour le nombre de votes de la réponse associée
                this.update_answer_nb_vote(2, savedVote);
                return savedVote;
            }
            LOGGER.debug("La mise à jour du vote a échoué.");
        } else {
            LOGGER.debug("Vote non trouvé avec l'ID : " + votes.getId());
        }
        return null;
    }
//je dois modiffier ça chaque une seule indépendante de l autre
    public void delete(String id) {
   Votes vote=voteRepository.findVotesById(id);
   if(vote.getTeacher().getValidVoteCount()>0 ){
       vote.getTeacher().setValidVoteCount(vote.getTeacher().getValidVoteCount()-1);
       userRepository.save(vote.getTeacher());
   }
        if(vote.getTeacher().getNbVoteForIncentives()>0 ){
            vote.getTeacher().setNbVoteForIncentives(vote.getTeacher().getNbVoteForIncentives()-1);
            userRepository.save(vote.getTeacher());

        }
   voteRepository.delete(vote); // Supprimer le vote de la base de données
            update_answer_nb_vote(-1, vote); // Mettre à jour le nombre de votes associé

    }

    public Votes  getVoteByUserAndAnswer(String userId, String answerId){
        UserCourzelo u= userRepository.findUserCourzeloById(userId);
        Answer a= answerRepository.findAnswerById(answerId);
        if(u!=null && a!=null){
            return voteRepository.findVotesByTeacherAndAnswer(u,a);
        }
        return null ;
    }

    public List<Incentives> IncetivesByTeacher(String idUser){
        UserCourzelo u= userRepository.findUserCourzeloById(idUser);
        return incentivesRepo. findIncentivesByTeacherOrderByDateOFObtainingDesc(u);
    }

    public Incentives approuvedChat(String iduser){
        UserCourzelo u= userRepository.findUserCourzeloById(iduser);
        Incentives i = new Incentives();
        i.setTeacher(u);
        i.setIncentivesType(IncentiveExplanation);
        i.setDateOFObtaining(new Date());
        Calendar calendar = Calendar.getInstance();
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) ;
       // calendar.setTime(new Date());
        //calendar.add(Calendar.MONTH, 1);
       // i.setDeliberationDate(calendar.getTime());
       // Incentives ins=incentivesRepo.save(i);
        u.setApproved(true);
        userRepository.save(u);
       scheduleResetApprouved(u);
        if(dayOfMonth<=u.getPaymentDay()){
            calendar.set(Calendar.MONTH, month );
            // Obtenez la date résultante
            Date deliberationDate = calendar.getTime();
            i.setDeliberationDate(deliberationDate);
            Incentives ins=incentivesRepo.save(i);

            //List<Incentives> list= incentivesRepo.findIncentivesByOrderByDateOFObtainingDesc();



            LOGGER.info("incentive*************"+dayOfMonth);
            LOGGER.info("incentive*************"+u.getUsername());
            return ins;
        } else {
            calendar.set(Calendar.MONTH, month+1 );
            Date deliberationDate = calendar.getTime();
            i.setDeliberationDate(deliberationDate);
            Incentives ins=incentivesRepo.save(i);

            LOGGER.info("incentive*************333  "+month);
            return ins;

        }

        //return ins;

    }

    private void scheduleResetApprouved(UserCourzelo u) {
        // Utilisez une tâche planifiée unique pour rétablir canVote à true après une minute supplémentaire
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                u.setApproved(false);

                userRepository.save(u); // Enregistrer la mise à jour dans la base de données
            }
        }, 60 * 1000); // Délai d'une minute en millisecondes  24 * 60 * 60 * 1000 apres24h
    }
    public List<BadgeForumTeacher> getBagesByUser(String id){
        UserCourzelo u= userRepository.findUserCourzeloById(id);
        return badgeForumTeacheRepo.findBadgeForumTeacherByTeacherOrderByDateDesc(u);

    }
    public UserCourzelo getUserById(String id){
        return userRepository.findUserCourzeloById(id);

    }
    public long rangeVoteIncentive(){
        long badge = badgeForumTeacheRepo.count();
        long incentives = incentivesRepo.count();
        long insVote = incentivesRepo.countAllByIncentivesType(IncentiveVote);
        LOGGER.info("Nombre de votes/**************" + insVote);
        long total = badge + incentives;
        LOGGER.info("Total/**************" + total);
        long percentage = 0;
        if (total != 0) {
            percentage = (insVote * 100) / total;
        }
        LOGGER.info("Pourcentage/**************" + percentage);
        return percentage;
    }
    public long rangeExplanIncentive(){
        long badge = badgeForumTeacheRepo.count();
        long incentives = incentivesRepo.count();
        long insExplanation = incentivesRepo.countAllByIncentivesType(IncentiveExplanation);
        LOGGER.info("Nombre d'explications/**************" + insExplanation);
        long total = badge + incentives;
        LOGGER.info("Total/**************" + total);
        long percentage = 0;
        if (total != 0) {
            percentage = (insExplanation * 100) / total;
        }
        LOGGER.info("Pourcentage/**************" + percentage);
        return percentage;
    }
    public long rangeBadge(){
        long badge = badgeForumTeacheRepo.count();
        long incentives = incentivesRepo.count();
        long total = badge + incentives;
        LOGGER.info("Total de badges et d'incitations/**************" + total);
        long percentage = 0;
        if (total != 0) {
            percentage = (badge * 100) / total;
        }
        LOGGER.info("Pourcentage de badges/**************" + percentage);
        return percentage;
    }






}
