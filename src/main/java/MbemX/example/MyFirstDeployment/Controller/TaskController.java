package MbemX.example.MyFirstDeployment.Controller;

import MbemX.example.MyFirstDeployment.Model.Task;
import MbemX.example.MyFirstDeployment.Services.TaskServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskServices taskServices;

    public TaskController(TaskServices taskServices) {
        this.taskServices = taskServices;
    }

    @GetMapping("/alltasks")
    public ResponseEntity<List<Task>> findAllTask() {
        return ResponseEntity.ok(taskServices.findAllTasks());
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id) {
        return ResponseEntity.ok(taskServices.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Task> save(@RequestBody Task task) {
        return ResponseEntity.ok(taskServices.save(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        Task task = taskServices.findById(id);
        taskServices.deleteTask(task);
        return ResponseEntity.noContent().build();
    }
}