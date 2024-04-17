package tn.esprit.courzelo.Repositories.ProjectRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.courzelo.entities.ProjectEntities.GroupProject;
import tn.esprit.courzelo.entities.ProjectEntities.Project;
import tn.esprit.courzelo.entities.ProjectEntities.Status;
import tn.esprit.courzelo.entities.ProjectEntities.Tasks;

import java.util.List;

public interface TasksRepo extends MongoRepository<Tasks,String> {
    List<Tasks> findTasksByProject (Project project);

    List<Tasks> findByProjectId(String projectId);
    List<Tasks> findByStatus(Status status);
}
