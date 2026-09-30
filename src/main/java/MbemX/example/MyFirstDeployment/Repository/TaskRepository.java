package MbemX.example.MyFirstDeployment.Repository;

import MbemX.example.MyFirstDeployment.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
