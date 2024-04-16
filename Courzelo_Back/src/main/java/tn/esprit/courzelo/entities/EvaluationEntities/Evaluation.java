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

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Evaluation")
public class Evaluation {
    @Id
    private  String id;
    @Indexed
    private int  AttendanceGrade;
    @Indexed
    private int QuizGrade;
    @Indexed
    private int finaltest_grade;
    @Indexed
    private String honors;
    @Indexed
    private int rank;
    @Indexed
    private int rankClass;
    @Indexed
    private double ModuleAverage;
    @Indexed
    private double finalAverage;
    @Indexed
    private EvaluationType evaluationType;
    @Indexed
    private String comments;
    @Indexed
    private int rankModule;
    @DBRef
    private List<Test> tests;
    @DBRef
    private UserCourzelo student;
    @DBRef
    private Module module;

}
