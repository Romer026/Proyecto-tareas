package CasoTWS.Ejercicio1.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class Task {
        @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskid;
    @NotNull
    private String title;
    private String description;
    private String status;
    // private projectId;

     /**RELACION CLAVES FORANEAS*/
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "projectid")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Project project;

}
