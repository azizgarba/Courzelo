package tn.esprit.courzelo.Repositories.EvaluationRepo;


import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.courzelo.entities.EvaluationEntities.Evaluation;
import tn.esprit.courzelo.entities.EvaluationEntities.QuestionTest;

public interface QuestionTestRepo extends MongoRepository<QuestionTest, String> {
}