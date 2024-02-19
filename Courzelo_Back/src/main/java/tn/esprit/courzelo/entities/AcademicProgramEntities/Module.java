package tn.esprit.courzelo.entities.AcademicProgramEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import tn.esprit.courzelo.entities.EvaluationEntities.Evaluation;
import tn.esprit.courzelo.entities.ForumEntities.QuestionForum;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Module")
@JsonIgnoreProperties({ "questionForums"})
public class Module {
    @Id
    private  String id;
    @Indexed
    private String name;
    @Indexed
    private String description;
    @Indexed
    private int nbHeurePerWeek;
    @Indexed
    private int nbHeureTotal;
    @Indexed
    private String image;
    @Indexed
    private Float couef;
    @DBRef
    private List<Course> courses;
 @DBRef
 private List<Evaluation> evaluation;
 @DBRef
    private List<EducationalProgram> educationalPrograms;
 @DBRef
    private List<QuestionForum> questionForums;
}
