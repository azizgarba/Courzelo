package tn.esprit.courzelo.Services.ForumService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.courzelo.Repositories.ForumRepo.AnswerRepository;
import tn.esprit.courzelo.Repositories.ForumRepo.VoteRepo;
import tn.esprit.courzelo.Repositories.UserRepo.UserRepo;
import tn.esprit.courzelo.entities.ForumEntities.Answer;
import tn.esprit.courzelo.entities.ForumEntities.Votes;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

@Service
@AllArgsConstructor
public class VoteServiceImpl {
    private  AnswerServiceImpl answerService ;
    private VoteRepo  voteRepository;
    private UserRepo userRepo;
    private AnswerRepository answerRepository;
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

        UserCourzelo u = userRepo.findUserCourzeloById(userId);
        Answer a = answerRepository.findAnswerById(answerId);
          Date now= new Date();
        if (u != null && a != null) {
            vote.setTeacher(u);
            vote.setAnswer(a);
            vote.setDate(now);
            Votes savedVote = voteRepository.save(vote);
            if(savedVote!=null) {
                // Mettre à jour le nombre de votes de la réponse associée
                this.update_answer_nb_vote(1, savedVote);
                return savedVote;
            }
            LOGGER.debug("vote est nulllllllllllllllllllllllll");
        }
         return null ;
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

    public void delete(String id) {
   Votes vote=voteRepository.findVotesById(id);
   voteRepository.delete(vote); // Supprimer le vote de la base de données
            update_answer_nb_vote(-1, vote); // Mettre à jour le nombre de votes associé

    }

    public Votes  getVoteByUserAndAnswer(String userId, String answerId){
        UserCourzelo u= userRepo.findUserCourzeloById(userId);
        Answer a= answerRepository.findAnswerById(answerId);
        if(u!=null && a!=null){
            return voteRepository.findVotesByTeacherAndAnswer(u,a);
        }
        return null ;
    }


}
