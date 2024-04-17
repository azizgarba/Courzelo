package tn.esprit.courzelo.Services.ProjectService;

import tn.esprit.courzelo.entities.ProjectEntities.Project;
import tn.esprit.courzelo.entities.ProjectEntities.Status;
import tn.esprit.courzelo.entities.ProjectEntities.Tasks;

import java.util.List;

public interface ITaskService {

    void moveTask(String id, Status newStatus);
    List<Tasks> getTasksByProjectId(String projectId);
    List<Tasks> getTasksByStatus(Status status);

}
