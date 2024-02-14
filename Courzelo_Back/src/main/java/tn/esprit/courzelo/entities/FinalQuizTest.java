package tn.esprit.courzelo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "FinalQuizTest")
public class FinalQuizTest {
    @Id
    private long id;
    private Type type;
    private String duration;
    private Date date;
    private int mark;
    private int nbQst;
    private int rank;
    @DBRef
    private List<QuestionTest> questions;
    @DBRef
    private Module module;
    @DBRef
    private User_c student;
    @DBRef
    private User_c teacher;
    @DBRef
    private List<Evaluation> evaluations;
}
