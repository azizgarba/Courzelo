package tn.esprit.courzelo.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.courzelo.entities.QuestionForum;

public interface QuestionForumRepo  extends MongoRepository<QuestionForum,Long> {
}
