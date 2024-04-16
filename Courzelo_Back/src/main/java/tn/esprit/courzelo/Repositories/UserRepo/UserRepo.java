package tn.esprit.courzelo.Repositories.UserRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.courzelo.entities.ForumEntities.QuestionForum;
import tn.esprit.courzelo.entities.UserCorzelo.Role;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.List;

public interface UserRepo  extends MongoRepository<UserCourzelo,String> {
    List<UserCourzelo> findAllByRole(Role role);

}
