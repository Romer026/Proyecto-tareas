package CasoTWS.Ejercicio1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import CasoTWS.Ejercicio1.models.Project;

@Repository
public interface ProjectRepository extends JpaRepository< Project , Long>{

    // List<Project> findByU(String nombreusuario);
    // List <Project> findByIdProject(Long projectid);
    //  @Query("SELECT p.name,p.description FROM Project p where p.projectid =: projectid")
    // List<Project> findByProjectid(Long projectid);

    // List <Project> findbyidproject(Long projectid);
    // @Query("delete from project where project.projectid = :projectid")
    // void deleteprojectbyid(Long projectid);
    
}
