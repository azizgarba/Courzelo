package tn.esprit.courzelo.entities.EvaluationEntities;

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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "FinalQuizTest")
public class Test {
    @Id
    private  String id;
    @Indexed
    private Type type;
    @Indexed
    private String duration;
    @Indexed
    private Date date;
    @Indexed
    private int mark;
    @Indexed
    private int nbQst;
    @Indexed
    private int rank;
    @DBRef
    private List<QuestionTest> questions;
    @DBRef
    private Module module;
    @DBRef
    private UserCourzelo student;
    @DBRef
    private UserCourzelo teacher;
    @DBRef
    private List<Evaluation> evaluations;
}
