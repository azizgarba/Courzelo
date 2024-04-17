package tn.esprit.courzelo.entities.AcademicProgramEntities;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data

@Document(collection = "Course")
public class Course {
    @Id
    private String id;
    @Indexed
    private String name;
    @Indexed
    private String description;
    @DBRef
    private Module module;
    @DBRef
    private List<Ressources> ressources;

    @DBRef
    private Filecalss filecalss;





}
