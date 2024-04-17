package tn.esprit.courzelo.Repositories.ProjectRepo;

import org.springframework.data.mongodb.repository.MongoRepository;

import tn.esprit.courzelo.entities.ProjectEntities.Project;

import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.Collection;
import java.util.List;

public interface ProjectRepo extends MongoRepository<Project,String> {

    List<Project> findProjectsByUsersIn(Collection<UserCourzelo> users);

 Project getById (String id);
}
