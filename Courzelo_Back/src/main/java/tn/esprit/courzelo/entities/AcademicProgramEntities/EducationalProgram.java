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
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "EducationalProgram")
public class EducationalProgram {
    @Id
    private  String id;
    @Indexed
    private String name;
    @Indexed
    private String description;
    private String year;
    @DBRef
    private Level level;
}
