package tn.esprit.courzelo.entities.FeedBackEntities;

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
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "QuestionFeedback")
public class QuestionFeedback {
    @Id
    private  String id;
    @Indexed
    private String description;
    @Indexed
    private TypeOption typeOption;
    @DBRef
    private UserCourzelo Admin;
}
