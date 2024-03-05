package tn.esprit.courzelo.Repositories.ForumRepo;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.courzelo.entities.ForumEntities.Answer;
import tn.esprit.courzelo.entities.ForumEntities.QuestionForum;

import java.util.List;



public interface AnswerRepository extends MongoRepository<Answer, String> {
    // Ajoutez des méthodes personnalisées si nécessaire
    Answer findAnswerById(String Id);


    List<Answer> findAnswerByQuestionForumOrderByDateDesc(QuestionForum q);

    List<Answer> findAnswerByOrderByDateAsc() ;
    List<Answer> findAnswersByQuestionForumOrderByNbrVoteDesc(QuestionForum questionForum);




    //List<Answer> findByQuestionForumOrderByNbr_voteDesc(QuestionForum f);
}

