package tn.esprit.courzelo.Repositories.ForumRepo;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.courzelo.entities.ForumEntities.Answer;


@Repository
public interface AnswerRepository extends MongoRepository<Answer, String> {
    // Ajoutez des méthodes personnalisées si nécessaire
}
