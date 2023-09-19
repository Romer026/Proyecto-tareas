package CasoTWS.Ejercicio1.service.implement;

// import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CasoTWS.Ejercicio1.models.Project;
import CasoTWS.Ejercicio1.models.Task;
import CasoTWS.Ejercicio1.repository.ProjectRepository;
import CasoTWS.Ejercicio1.repository.TaskRepository;
import CasoTWS.Ejercicio1.service.TaskService;
import CasoTWS.Ejercicio1.utils.GenericResponse;
import CasoTWS.Ejercicio1.utils.ParametersApp;

@Service
public class TaskImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public GenericResponse<Object> createTask(Task task) {
        GenericResponse<Object> response = new GenericResponse<>();
        try {
            System.out.println(task + "imprmiendo lo que recibe project y task");
            if (projectRepository.findById(task.getProject().getProjectid()).isPresent()) {
                Project project = projectRepository.findById(task.getProject().getProjectid()).get();

                task.setTitle(task.getTitle().toUpperCase());
                task.setDescription(task.getDescription().toUpperCase());
                task.setStatus(task.getStatus().toUpperCase());
                task.getProject().setProjectid(project.getProjectid());
                taskRepository.save(task);
                System.out.println(task + "imprmiendo lo que recibe project y task");
                response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
                response.setObject(task + "Task created");
                response.setStatus(ParametersApp.SUCCESSFUL.value());
            } else {
                response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
                response.setObject("task exists");
                response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
            }
        } catch (Exception e) {
            response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
            response.setObject("Error: " + e);
            response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
        }
        return response;
    }

    @Override
    public List<Task> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Task getTaskById(Long taskid) {
        Task task = taskRepository.findById(taskid).get();
        return task;

    }

    @Override
    public GenericResponse deleteTask(Long taskid) {
        GenericResponse<String> response = new GenericResponse<>();
        try {
            taskRepository.deleteById(taskid);
            response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
            response.setObject("Tarea eliminada de la base de datos");
            response.setStatus(ParametersApp.SUCCESSFUL.value());
        } catch (Exception e) {
            response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
            response.setObject("Error " + e);
            response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
        }
        return response;
    }

    @Override
    public GenericResponse<Object> putTask(Long taskid,  String description, String status,
            String title,Long projectid) {
        GenericResponse<Object> response = new GenericResponse<>();

        try {
            Task existingTask = taskRepository.findById(taskid).get();
            Project project = projectRepository.findById(projectid).get();

            if (existingTask != null && project.getProjectid() != null) {
                existingTask.setTitle(title);
                existingTask.setDescription(description);
                existingTask.setStatus(status);
                existingTask.setProject(project);
                taskRepository.save(existingTask);

                response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
                response.setObject(existingTask);
                response.setStatus(ParametersApp.SUCCESSFUL.value());
            } else {
                response.setMessage(ParametersApp.NOT_FOUND_RECORDS.getReasonPhrase());
                response.setObject("No se encontro informacion");
                response.setStatus(ParametersApp.NOT_FOUND_RECORDS.value());

            }
        } catch (Exception e) {
            response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
            response.setObject("Error" + e);
            response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
        }
        return response;
    }

    @Override
    public GenericResponse getTaskByIdproject(Long projectid) {
        GenericResponse<Object> response = new GenericResponse<>();
        try {
            if (projectRepository.findById(projectid).isEmpty() == false) {
                Project project = projectRepository.findById(projectid).get();
                List<Task> taskarray = new ArrayList<>();
                List<Task> tasklList = taskRepository.getTaskByIdproject(project.getProjectid());
                tasklList.forEach(doc -> {
                    Task task = new Task();
                    task.setTaskid(doc.getTaskid());
                    task.setTitle(doc.getTitle());
                    task.setDescription(doc.getDescription());
                    task.setStatus(doc.getStatus());
                    task.setProject(doc.getProject());
                    taskarray.add(task);
                    // System.out.println(taskarray);
                });
                response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
                response.setObject(taskarray);
                response.setStatus(ParametersApp.SUCCESSFUL.value());
            } else {
                response.setMessage(ParametersApp.NOT_FOUND_RECORDS.getReasonPhrase());
                response.setObject("No se encontro informacion");
                response.setStatus(ParametersApp.NOT_FOUND_RECORDS.value());

            }
        } catch (Exception e) {
            // TODO: handle exception
            response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
            response.setObject("Error" + e);
            response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
        }
        return response;

    }

}
