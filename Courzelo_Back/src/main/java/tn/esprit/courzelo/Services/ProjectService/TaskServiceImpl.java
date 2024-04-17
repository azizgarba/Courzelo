package tn.esprit.courzelo.Services.ProjectService;

import jakarta.el.MethodNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.courzelo.Repositories.ProjectRepo.TasksRepo;
import tn.esprit.courzelo.entities.ProjectEntities.Status;
import tn.esprit.courzelo.entities.ProjectEntities.Tasks;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskServiceImpl implements ITaskService {
    private final TasksRepo tasksRepo;

    @Override
    public List<Tasks> getTasksByProjectId(String projectId) {
        return tasksRepo.findByProjectId(projectId);
    }
    @Override
    public void moveTask(String id, Status newStatus) {
        Optional<Tasks> optionalTask = tasksRepo.findById(id);
        if (optionalTask.isPresent()) {
            Tasks task = optionalTask.get();
            task.setStatus(newStatus);
            tasksRepo.save(task);
        } else {
            throw new MethodNotFoundException("Task not found with id: " + id);
        }
    }

    @Override
    // Method to get tasks by status
    public List<Tasks> getTasksByStatus(Status status) {
        return tasksRepo.findByStatus(status);
    }
}
