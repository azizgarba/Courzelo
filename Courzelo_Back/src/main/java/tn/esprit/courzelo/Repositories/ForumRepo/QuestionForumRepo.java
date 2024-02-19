package tn.esprit.courzelo.Repositories.ForumRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.courzelo.entities.ForumEntities.QuestionForum;

public interface QuestionForumRepo  extends MongoRepository<QuestionForum,String> {
}
