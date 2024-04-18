package tn.esprit.courzelo.Repositories.UserRepo;

import org.springframework.stereotype.Repository;
import tn.esprit.courzelo.entities.UserCorzelo.User;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
    Optional<User> findUserByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
