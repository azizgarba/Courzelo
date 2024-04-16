package tn.esprit.courzelo.Repositories.EvaluationRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.courzelo.entities.EvaluationEntities.Evaluation;
import tn.esprit.courzelo.entities.EvaluationEntities.Test;

public interface TestRepo extends MongoRepository<Test, String> {
}
