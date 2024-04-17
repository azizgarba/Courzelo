package tn.esprit.courzelo.Controllers.Project;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.courzelo.Services.ProjectService.IProjectService;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Level;
import tn.esprit.courzelo.entities.ProjectEntities.Project;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.List;
@RestController
@AllArgsConstructor
@Tag(name = "Project")
public class ProjectController {

    private final IProjectService iProjectService;

    @GetMapping("/listofProjects")
    public List<Project> getAllProjects(){
        return iProjectService.GetProject();
    }





    @PostMapping("/addProject")
    public Project addProject(@RequestBody Project project){
        return  iProjectService.addProject(project);
    }

    @PutMapping("/UpdatelProject")
    public Project UpdatelProject(@RequestBody Project project)

    {
        return  iProjectService.updateProject(project);
    }

    @DeleteMapping("DeleteProject/{id}")
    public void deleteProject(@PathVariable("id") String id){
        iProjectService.removeProject(id);
    }

    @GetMapping("getProjectbyid/{id}")
    public Project getById(@PathVariable("id") String id){
        return iProjectService.getById(id);
    }


    // Static method to mock user retrieval
  /*  private UserCourzelo retrieveUserByIdStatically(String userId) {
        // Assuming userId is the unique identifier for the user
        if (userId.equals("65fd917e1016964e8d5650d7")) {
            return new UserCourzelo("65fd917e1016964e8d5650d7"); // Replace with your actual user object creation logic
        }
        // If user is not found, return null
        return null;
    }*/

}
