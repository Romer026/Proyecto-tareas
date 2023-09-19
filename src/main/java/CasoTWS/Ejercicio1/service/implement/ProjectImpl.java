package CasoTWS.Ejercicio1.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CasoTWS.Ejercicio1.models.Project;
import CasoTWS.Ejercicio1.models.Task;
import CasoTWS.Ejercicio1.repository.ProjectRepository;
import CasoTWS.Ejercicio1.repository.TaskRepository;
import CasoTWS.Ejercicio1.service.ProjectService;
import CasoTWS.Ejercicio1.utils.GenericResponse;
import CasoTWS.Ejercicio1.utils.ParametersApp;

@Service
public class ProjectImpl implements ProjectService {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    ProjectRepository projectRepository;

    @Override
    public Project getProjectById(Long projectid) {
        // TODO Auto-generated method stub
        Project project = projectRepository.findById(projectid).get();
        return project;
    }

    @Override
    public GenericResponse deleteProject(Long projectid) {
        GenericResponse<String> response = new GenericResponse<>();
        try {
            // List<Task> tasks = taskRepository.findbyidProject(projectid);
            // tasks.forEach(task->{
            // task.setProject(null);
            // taskRepository.save(task);
            // });

            // List<Task> tasks = taskRepository.removeByIdproject(projectid);
            // tasks.forEach(task -> {
            //     taskRepository.removeByIdproject(projectid);
            // });
            // taskRepository.removeByIdproject(projectid);
            projectRepository.deleteById(projectid);
            response.setMessage(ParametersApp.SUCCESSFUL.getReasonPhrase());
            response.setObject("Proyecto eliminado de la base de datos");
            response.setStatus(ParametersApp.SUCCESSFUL.value());

        } catch (Exception e) {
            response.setMessage(ParametersApp.PROCESS_NOT_COMPLETED.getReasonPhrase());
            response.setObject("Error " + e);
            response.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
        }
        return response;

    }

}
