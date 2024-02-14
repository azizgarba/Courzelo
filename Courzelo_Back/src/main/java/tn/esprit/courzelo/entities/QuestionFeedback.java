package tn.esprit.courzelo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "QuestionFeedback")
public class QuestionFeedback {
    @Id
    private long id;
    private String description;
    private Option option;
    @DBRef
    private User_c Admin;
}
