package tn.esprit.courzelo.Services.ForumService;


import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import tn.esprit.courzelo.Repositories.ForumRepo.AnswerRepository;
import tn.esprit.courzelo.Repositories.ForumRepo.QuestionForumRepo;
import tn.esprit.courzelo.Repositories.ForumRepo.RateQuestionRepo;
import tn.esprit.courzelo.Repositories.ForumRepo.VoteRepo;
import tn.esprit.courzelo.Repositories.ModuleRepo.ModuleRepo;
import tn.esprit.courzelo.Repositories.UserRepo.UserRepository;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Module;
import tn.esprit.courzelo.entities.ForumEntities.Answer;
import tn.esprit.courzelo.entities.ForumEntities.QuestionForum;
import tn.esprit.courzelo.entities.ForumEntities.RateQuestion;
import tn.esprit.courzelo.entities.ForumEntities.Votes;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.List;

import java.util.*;

@Service
@AllArgsConstructor
public class QuestionForumImpl  {
    QuestionForumRepo questionForumRepo ;
    AnswerRepository answerRepository;
    ModuleRepo moduleRepo ;
    UserRepository userRepository;
    RateQuestionRepo rateQuestionRepo;
    VoteRepo voteRepo;


    // Create or Update
    public QuestionForum AddQuestion(QuestionForum questionForum, String idUser , String idModule ) {
       Module module =moduleRepo.findModuleById(idModule);
        Date now = new Date();
        UserCourzelo u= userRepository.findUserCourzeloById(idUser);
        if(module!=null && u!= null){
            questionForum.setModule(module);
            questionForum.setStudent(u);
            questionForum.setTotalNbRate(0);
            questionForum.setDate(now);
            return questionForumRepo.save(questionForum);


        }
        return null;

    }

    // Read
    public List<QuestionForum> getAllQuestions() {
        return  questionForumRepo.findQuestionForumByOrderByDateDesc();
    }

    public QuestionForum getQuestionById(String id) {
        return questionForumRepo.findQuestionForumById(id);
    }

    // Update
    public QuestionForum updateQuestion(QuestionForum updatedQuestion) {
        QuestionForum existingQuestionOptional = questionForumRepo.findQuestionForumById(updatedQuestion.getId());

        // Vérifier si la question existe
        if (existingQuestionOptional!= null) {

            // Mettre à jour les attributs de la question existante avec les nouvelles valeurs
            existingQuestionOptional.setTitle(updatedQuestion.getTitle());
            existingQuestionOptional.setDescription(updatedQuestion.getDescription());
            existingQuestionOptional.setModule(updatedQuestion.getModule());

            // Sauvegarder les modifications dans la base de données
            return questionForumRepo.save(existingQuestionOptional);
        } else {

            return null ;
        }
    }

    // Delete
    public void deleteQuestionById(String id) {
        QuestionForum q =  questionForumRepo.findQuestionForumById(id);
        List<Answer> a=answerRepository.findAnswerByQuestionForumOrderByDateDesc(q);
        List<RateQuestion> qr= rateQuestionRepo.findRateQuestionByQuestionForum(q);



        //List<Votes> v = voteRepo.findVotesByAnswer()

        if (q != null) {

            if ( a!=null)  {
                for (Answer answer : a) {
                    List<Votes> v = voteRepo.findVotesByAnswer(answer);
                    if ( v!=null){
                        voteRepo.deleteAll(v);
                    }
                }
                // Utilisez une boucle for each pour itérer sur les votes
                answerRepository.deleteAll(a);

            }
            if ( qr!=null)  {
                // Utilisez une boucle for each pour itérer sur les votes
                rateQuestionRepo.deleteAll(qr);

            }
            // Supprimez la réponse une fois que les votes associés ont été supprimés
            questionForumRepo.delete(q);
        }

    }
    public QuestionForum updateQuestionRate(QuestionForum updatedQuestion) {
        QuestionForum existingQuestionOptional = questionForumRepo.findQuestionForumById(updatedQuestion.getId());

        // Vérifier si la question existe
        if (existingQuestionOptional!= null) {

            existingQuestionOptional.setTotalNbRate(updatedQuestion.getTotalNbRate());

            // Sauvegarder les modifications dans la base de données
            return questionForumRepo.save(existingQuestionOptional);
        } else {

            return null ;
        }
    }

    public List<QuestionForum> getQuestionByModule(String idModule){
        Module module =moduleRepo.findModuleById(idModule);
        if(module!=null){
            return questionForumRepo.findQuestionForumByModule(module);
        }
        return null;
    }
    //search by title
    public List<QuestionForum> getQuestionByTitle(String title){
        return questionForumRepo.findQuestionForumByTitleContaining(title);
    }




}
