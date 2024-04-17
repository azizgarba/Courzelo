package tn.esprit.courzelo.Services.ProjectService;

import tn.esprit.courzelo.entities.AcademicProgramEntities.Level;
import tn.esprit.courzelo.entities.ProjectEntities.Project;
import tn.esprit.courzelo.entities.ProjectEntities.Tasks;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.List;

public interface IProjectService {

    List<Project> GetProject();
    Project addProject(Project project) ;
    void removeProject (String id );
    Project updateProject(Project project);
    Project getById(String id);

}


