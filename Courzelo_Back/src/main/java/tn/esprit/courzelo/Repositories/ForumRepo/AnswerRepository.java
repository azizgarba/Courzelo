package tn.esprit.courzelo.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.courzelo.entities.Answer;

@Repository
public interface AnswerRepository extends MongoRepository<Answer, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
}
