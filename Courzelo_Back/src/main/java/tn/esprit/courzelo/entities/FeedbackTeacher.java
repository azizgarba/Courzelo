package tn.esprit.courzelo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "FeedbackTeacher")
public class FeedbackTeacher {
    @Id
    private  String id;
    @Indexed
    private String description;
    @DBRef
    private UserCourzelo student;
    @DBRef
    private UserCourzelo teacher;
    @DBRef
    private QuestionFeedback questionFeedback;
}
