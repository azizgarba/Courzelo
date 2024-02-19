package tn.esprit.courzelo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
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
    private  String id;
    @Indexed
    private int  AttendanceGrade;
    @Indexed
    private int QuizGrade;
    @Indexed
    private int finaltest_grade;
    @Indexed
    private int honors;
    @Indexed
    private int rank;
    @DBRef
    private List<FinalQuizTest> finalQuizTests;
}
