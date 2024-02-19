package tn.esprit.courzelo.Repositories.FeedbackRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.courzelo.entities.FeedBackEntities.QuestionFeedback;

@Repository
public interface QuestionFeedbackRepo extends MongoRepository<QuestionFeedback, String> {
}
