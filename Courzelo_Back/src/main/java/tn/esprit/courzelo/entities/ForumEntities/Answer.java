package tn.esprit.courzelo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Document(collection = "Answer")
@JsonIgnoreProperties({ "votes"})
public class Answer {
    @Id
    private long id;
    private String message;
    private int nbr_vote;
    private boolean getBudget;
    @DBRef
    private QuestionForum questionForum;
    @DBRef
    private User_c student;
    @DBRef
    private User_c teacher;
    @DBRef
    private List<Votes> votes;
}
