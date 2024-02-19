package tn.esprit.courzelo.entities.AcademicProgramEntities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Ressources")
public class Ressources {
    @Id
    private  String id;
    @Indexed
    private String name;
    @Indexed
    private String path;
    @DBRef
    private Course course;
}
