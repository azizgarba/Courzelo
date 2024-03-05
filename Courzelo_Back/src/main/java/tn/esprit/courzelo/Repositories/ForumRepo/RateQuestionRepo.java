package tn.esprit.courzelo.Repositories.ForumRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.courzelo.entities.ForumEntities.RateQuestion;

public interface RateQuestion  extends MongoRepository<RateQuestion,String> {
}
