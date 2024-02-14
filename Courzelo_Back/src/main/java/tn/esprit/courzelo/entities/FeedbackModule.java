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
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "FeedbackModule")
public class FeedbackModule {
    @Id
    private long id;
    private String description;
    @DBRef
    private User_c student;
    @DBRef
    private Module module;
    @DBRef
    private QuestionFeedback questionFeedback;
}
