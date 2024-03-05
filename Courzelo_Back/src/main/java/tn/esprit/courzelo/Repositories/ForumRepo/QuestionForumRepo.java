package tn.esprit.courzelo.Repositories.ForumRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Module;
import tn.esprit.courzelo.entities.ForumEntities.QuestionForum;

import java.util.List;

public interface QuestionForumRepo  extends MongoRepository<QuestionForum,String> {
    QuestionForum findQuestionForumById(String id);

    List<QuestionForum> findQuestionForumByOrderByDateDesc();
    List<QuestionForum> findQuestionForumByModule(Module module);
    List<QuestionForum> findQuestionForumByTitleContaining(String title);

}
