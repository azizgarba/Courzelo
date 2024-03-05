package tn.esprit.courzelo.Services.ForumService;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import tn.esprit.courzelo.Repositories.ForumRepo.AnswerRepository;
import tn.esprit.courzelo.Repositories.ForumRepo.QuestionForumRepo;
import tn.esprit.courzelo.Repositories.ForumRepo.VoteRepo;
import tn.esprit.courzelo.Repositories.ModuleRepo.ModuleRepo;
import tn.esprit.courzelo.Repositories.UserRepo.UserRepo;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Module;
import tn.esprit.courzelo.entities.ForumEntities.Answer;
import tn.esprit.courzelo.entities.ForumEntities.QuestionForum;
import tn.esprit.courzelo.entities.ForumEntities.Votes;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class AnswerServiceImpl {
    AnswerRepository answerRepository ;
    QuestionForumRepo questionForumRepository ;
    UserRepo userRepo ;
    ModuleRepo moduleRepo ;
    VoteRepo voteRepo;
    private MongoOperations mongoOperations;
    private static final Logger LOGGER = LoggerFactory.getLogger(AnswerServiceImpl.class);
    public List<Answer> getAllAnswers() {
        return answerRepository.findAnswerByOrderByDateAsc();
    }

    public Answer getAnswerById(String id) {
        Answer s= answerRepository.findAnswerById(id);
        LOGGER.info("*************************<<<<"+s.getVotes());
        return s ;

    }

    public Answer createAnswer(Answer answer,String userId, String questionId) {
        QuestionForum question = questionForumRepository.findQuestionForumById(questionId);
        UserCourzelo u = userRepo.findUserCourzeloById(userId);
        Date now = new Date();
        if ( question !=null && u!= null) {

            answer.setQuestionForum( question );
            answer.setUser(u);
            answer.setDate(now);
            answer.setNbrVote(0);
            answer.setGetBudget(false);
            return answerRepository.save(answer);
        } else {
            // Gérer le cas où la question n'est pas trouvée
            return null;
        }
    }

    public void deleteAnswerById(String id) {
        Answer a= answerRepository.findAnswerById(id);
        answerRepository.delete(a);
    }
    public Answer updateAnswer(Answer a){
        return  answerRepository.save(a);

    }
    public  List<Answer> getAllAnswersByQuestion(String id){
        QuestionForum q= questionForumRepository.findQuestionForumById(id);
        return answerRepository.findAnswerByQuestionForumOrderByDateDesc(q);

    }

    public List<Module> getAllModule() {

        return moduleRepo.findAll();

    }
    public Module findIdModuleByName(String name){
        return moduleRepo.findModuleByName(name);

    }

    // Partie Vote
    public Answer updateVote(Answer answer) {

           return  answerRepository.save(answer);

    }
    public void deleteAnswer(String answerId) {
        Answer answer = answerRepository.findAnswerById(answerId);
        List<Votes> votes= voteRepo.findVotesByAnswer(answer);

        if (answer != null) {
            LOGGER.info("***********************"+votes);
            if ( votes!=null) {
                // Utilisez une boucle for each pour itérer sur les votes
                voteRepo.deleteAll(votes);
            }
            // Supprimez la réponse une fois que les votes associés ont été supprimés
            answerRepository.delete(answer);
        }
    }
    public int getNombreVoteAnswer(String idAnswer){
        Answer a= answerRepository.findAnswerById(idAnswer);
        return a.getNbrVote();

    }
   public List<Answer> getAnswersOrderByNbVote(String s){
        QuestionForum q= questionForumRepository.findQuestionForumById(s);

        return answerRepository.findAnswersByQuestionForumOrderByNbrVoteDesc(q);
    }
}
