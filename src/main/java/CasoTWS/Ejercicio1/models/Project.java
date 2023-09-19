package CasoTWS.Ejercicio1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long projectid;
    @NotNull
    private String name;

    private String description;

  @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "project")
    List<Task> task;


//  @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
//     private List<Task> tasks;

    
}
