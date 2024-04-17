package tn.esprit.courzelo.Services.ProjectService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.courzelo.Repositories.ProjectRepo.GroupProjectRepo;
import tn.esprit.courzelo.Repositories.ProjectRepo.ProjectRepo;

import tn.esprit.courzelo.Repositories.ProjectRepo.TasksRepo;
import tn.esprit.courzelo.Repositories.UserRepo.UserRepo;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Level;
import tn.esprit.courzelo.entities.ProjectEntities.Project;
import tn.esprit.courzelo.entities.ProjectEntities.Tasks;
import tn.esprit.courzelo.entities.UserCorzelo.Role;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProjectServiceImpl  implements IProjectService{
    private final ProjectRepo projectRepo;
    private final GroupProjectRepo groupProjectRepo;
    private final TasksRepo tasksRepo;

    @Override
    public List<Project> GetProject() {
        List<Project> projects = projectRepo.findAll();
        for (Project project : projects) {
            boolean hasGroupProject = groupProjectRepo.existsByProjectId(project.getId());
            project.setHasGroupProject(hasGroupProject);

            // Fetch tasks associated with the project
            List<Tasks> tasks = tasksRepo.findTasksByProject(project);
            project.setTasks(tasks);
        }
        return projects;
    }
    @Override
    public Project addProject(Project project) {
        // Get the list of tasks associated with the project
        List<Tasks> tasksList = project.getTasks(); // Retrieve tasks from the project

        if (tasksList != null && !tasksList.isEmpty()) {
            // Save all tasks first to generate unique IDs
            tasksList = tasksRepo.saveAll(tasksList);
        }

        // Save the project after tasks to ensure tasks have IDs generated
        Project savedProject = projectRepo.save(project);

        // Final copy of savedProject for use in lambda expression
        final Project finalSavedProject = savedProject;

        // Associate tasks with the project
        tasksList.forEach(task -> {
            task.setProject(finalSavedProject);
            tasksRepo.save(task); // Save each task individually
        });

        // Update the project to include the saved tasks
        savedProject.setTasks(tasksList);

        // Return the saved project with associated tasks
        return projectRepo.save(savedProject);
    }

    @Override
    public void removeProject(String id) {
        projectRepo.deleteById(id);
    }

    @Override
    public Project updateProject( Project project)
        {
            return projectRepo.save(project);
        }

    @Override
    public Project getById(String id) {
        return projectRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("no  id " + id));
    }

}
