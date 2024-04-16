package tn.esprit.courzelo.Repositories.UserRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserCourzelo,String> {
    UserCourzelo findUserCourzeloById(String id);
    Optional<UserCourzelo> findUserByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}