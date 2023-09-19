package CasoTWS.Ejercicio1.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CasoTWS.Ejercicio1.repository.ProjectRepository;
import CasoTWS.Ejercicio1.service.ProjectService;
import CasoTWS.Ejercicio1.utils.GenericResponse;
import CasoTWS.Ejercicio1.models.Project;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class ProjectController {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectService projectService;

    @GetMapping("/get-all")
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // @CrossOrigin
    @GetMapping("/get-byid")
    public Project getById(@RequestParam(value = "projectid") Long projectid) {
        return projectService.getProjectById(projectid);
    }

    @PutMapping("/put-project")
    public ResponseEntity<Project> updateProject(
            @RequestParam("projectid") Long projectid,
            @RequestParam("name") String name,
            @RequestParam("description") String description) {
        Optional<Project> existingProject = projectRepository.findById(projectid);
         System.out.print("imprimiendo desde el back fuera del if"+ projectid + name +description);
        if (existingProject.isPresent()) {
            System.out.print("imprimiendo desde el back dentro del if"+ projectid + name +description);
            // Actualizar los datos del proyecto existente con los datos proporcionados
            Project project = existingProject.get();
            project.setName(name);
            project.setDescription(description);
            // Actualiza otros campos según sea necesario
            // project.setOtroCampo(otroCampo);

            Project savedProject = projectRepository.save(project);
            return ResponseEntity.ok(savedProject);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

  

    @PostMapping("/add-project/{name}/{description}")
    public Project createProject(@PathVariable("name") String name, @PathVariable("description") String description) {
        Project project = new Project();
        project.setName(name);
        project.setDescription(description);
        return projectRepository.save(project);
    }

    @DeleteMapping("/delete-project-base")
    ResponseEntity<GenericResponse> deleteprojectbase(
            @RequestParam(value = "projectid") Long projectid) {
        return new ResponseEntity<>(projectService.deleteProject(projectid), HttpStatus.OK);
    }

}
