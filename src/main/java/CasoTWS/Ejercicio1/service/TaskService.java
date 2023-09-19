package CasoTWS.Ejercicio1.service;

import java.util.List;

import CasoTWS.Ejercicio1.models.Task;
import CasoTWS.Ejercicio1.utils.GenericResponse;

public interface TaskService {

    GenericResponse<Object> createTask(Task task);
    GenericResponse<Object> putTask(Long taskid, String  description,String status, String title,Long projectid);

    List<Task> findAll();
    Task getTaskById(Long taskid);


    GenericResponse getTaskByIdproject(Long projectid);

    GenericResponse deleteTask(Long taskid);
    
}
