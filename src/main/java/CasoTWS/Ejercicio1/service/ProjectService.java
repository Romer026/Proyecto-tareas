package CasoTWS.Ejercicio1.service;

import CasoTWS.Ejercicio1.models.Project;
import CasoTWS.Ejercicio1.utils.GenericResponse;

public interface ProjectService {

    Project getProjectById(Long projectid);
    GenericResponse deleteProject(Long projectid);
    
}
