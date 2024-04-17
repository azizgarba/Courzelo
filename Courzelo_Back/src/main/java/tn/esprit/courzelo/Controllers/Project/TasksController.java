package tn.esprit.courzelo.Controllers.Project;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.esprit.courzelo.Services.ProjectService.IProjectService;
import tn.esprit.courzelo.Services.ProjectService.ITaskService;
import tn.esprit.courzelo.entities.ProjectEntities.Project;
import tn.esprit.courzelo.entities.ProjectEntities.Status;
import tn.esprit.courzelo.entities.ProjectEntities.Tasks;

import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name = "Tasks")
public class TasksController {

    private final ITaskService iTaskService;
    private final IProjectService iProjectService;

    @PutMapping("/{id}/move")
    public void moveTask(@PathVariable String id, @RequestParam Status newStatus) {
        iTaskService.moveTask(id, newStatus);
    }



    @GetMapping("/{projectId}/tasks")
    public ResponseEntity<List<Tasks>> getTasksByProject(@PathVariable String projectId) {
        List<Tasks> tasks = iTaskService.getTasksByProjectId(projectId);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/tasks/status/{status}")
    public List<Tasks> getTasksByStatus(@PathVariable Status status) {
        return iTaskService.getTasksByStatus(status);
    }


}
