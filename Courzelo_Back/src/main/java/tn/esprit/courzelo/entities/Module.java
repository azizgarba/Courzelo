package tn.esprit.courzelo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Module")
public class Module {
    @Id
    private long id;
    private String name;
    private String description;
    private int nbHeurePerWeek;
    private int nbHeureTotal;
    private String image;
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
