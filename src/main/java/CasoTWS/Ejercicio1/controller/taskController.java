package CasoTWS.Ejercicio1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import CasoTWS.Ejercicio1.models.Project;
import CasoTWS.Ejercicio1.models.Task;
import CasoTWS.Ejercicio1.service.TaskService;
import CasoTWS.Ejercicio1.utils.GenericResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class taskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/task")
    public List<Task> getAllTasks() {
        return taskService.findAll();
    }

    @CrossOrigin
    @GetMapping("/getById-project")
    public ResponseEntity<GenericResponse> getByIdProject(@RequestParam(value = "projectid") Long projectid) {
        return new ResponseEntity<GenericResponse>(taskService.getTaskByIdproject(projectid), HttpStatus.OK);
    }

    @PostMapping("/add-task")
    ResponseEntity<GenericResponse<Object>> saveTask(
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam String status,
            @RequestParam Long projectId) {
        // Crear un objeto Task utilizando los parámetros recibidos
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setStatus(status);

        // Crear un objeto Project para asociarlo con la tarea
        Project project = new Project();
        project.setProjectid(projectId);

        task.setProject(project);
        // System.out.println("imprimiendo lo que recibe el task"+ task);

        // Llamar al servicio para crear la tarea
        return new ResponseEntity<GenericResponse<Object>>(taskService.createTask(task), HttpStatus.OK);
    }

    @DeleteMapping("/delete-task-Base")
    ResponseEntity<GenericResponse<String>> eliminarTaskBase(
            @RequestParam(value = "taskid") Long taskid) {
        return new ResponseEntity<>(taskService.deleteTask(taskid), HttpStatus.OK);
    }

    @GetMapping("/getTask-byid")
    public Task getByIdTask(@RequestParam(value = "taskid") Long taskid) {
        return taskService.getTaskById(taskid);
    }

    @PutMapping("/put-Task")
    ResponseEntity<GenericResponse<Object>> updateTask(@RequestParam Long taskid,
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam String status,
            @RequestParam Long projectid){
        return new ResponseEntity<GenericResponse<Object>>(taskService.putTask(taskid, description, status, title,projectid),HttpStatus.OK);
    }

}
