package tn.esprit.courzelo.entities.EvaluationEntities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import tn.esprit.courzelo.entities.EvaluationEntities.QuestionTest;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Options")
public class QAnswer {
    @Id
    private String id;
    @Indexed
    private String name;
    @Indexed
    private String description;
    @DBRef
    private QuestionTest questionTest;
}
