package MbemX.example.MyFirstDeployment.Services;

import MbemX.example.MyFirstDeployment.Model.Task;
import MbemX.example.MyFirstDeployment.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServices {
    private final TaskRepository taskRepository;

    public TaskServices(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> findAllTasks(){
        return taskRepository.findAll();
    }
    public Task findById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }
    public Task save(Task task){
        return taskRepository.save(task);
    }
    public void deleteTask(Task task){
        taskRepository.delete(task);
    }
}
