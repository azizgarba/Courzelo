package tn.esprit.courzelo.entities.EvaluationEntities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Module;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "FinalQuizTest")
public class Test {
    @Id
    public  String id;
    @Indexed
    public Type type;
    @Indexed
    @NotBlank
    public String name;
    @Indexed
    public String description;
    @Indexed
    public String duration;
    @Indexed
    public Date date;
    @Indexed
    public int mark;
    @Indexed
    public int nbQst = 20;
    @Indexed
    public int rank;
    @DBRef
    @Size(min = 1)
    public List<QuestionTest> questions;
    @DBRef
    public Module module;
    @DBRef
    public UserCourzelo student;
    @DBRef
    public UserCourzelo teacher;
    @DBRef
    public List<Evaluation> evaluations;


}
