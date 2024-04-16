package tn.esprit.courzelo.Repositories.UserRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.courzelo.entities.ForumEntities.QuestionForum;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

public interface UserRepo  extends MongoRepository<UserCourzelo,String> {
    UserCourzelo findUserCourzeloById(String id);

}
