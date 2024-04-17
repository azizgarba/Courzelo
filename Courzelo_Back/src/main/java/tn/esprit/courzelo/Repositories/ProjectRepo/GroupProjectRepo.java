package tn.esprit.courzelo.Repositories.ProjectRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import tn.esprit.courzelo.entities.ProjectEntities.GroupProject;
import tn.esprit.courzelo.entities.ProjectEntities.Project;
import tn.esprit.courzelo.entities.UserCorzelo.Role;
import tn.esprit.courzelo.entities.UserCorzelo.Speciality;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.List;


public interface GroupProjectRepo extends MongoRepository<GroupProject,String> {

    boolean existsByProjectId(String projectId);
    List<GroupProject> findByStudentsId(String studentId);

}