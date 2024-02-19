package tn.esprit.courzelo.Repositories.FeedbackRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.courzelo.entities.FeedBackEntities.Feedback;

@Repository
public interface FeedbackRepo extends MongoRepository<Feedback, String> {
}
