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
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Evaluation")
public class Evaluation {
    @Id
    private long id;
    private int  AttendanceGrade;
    private int QuizGrade;
    private int finaltest_grade;
    private int honors;
    private int rank;
    @DBRef
    private List<FinalQuizTest> finalQuizTests;
}
