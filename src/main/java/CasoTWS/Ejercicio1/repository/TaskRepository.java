package CasoTWS.Ejercicio1.repository;

// import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import CasoTWS.Ejercicio1.models.Task;
import java.util.List;
// import antlr.collections.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    
    // List <Task> findByTitle(String title);
    // @Query(value="update from task where task.projectid = :projectid",nativeQuery = true)
    // List <Task> findbyidProject(Long projectid);

    // @Modifying
    @Query(value="select * from task where task.projectid = :projectid",nativeQuery = true)
    List <Task> getTaskByIdproject(Long projectid);

    @Query(value="delete from task where task.taskid = :taskid",nativeQuery = true)
    List <Task> removeById(@Param("taskid") Long projectid);
    

}
