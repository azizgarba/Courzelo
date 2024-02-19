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
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "QuestionTest")
public class QuestionTest {
    @Id
    private String id;
    @Indexed
    private int number;
    @Indexed
    private String description;
 @DBRef
        private List<OptionsTest> answers;
    private List<String> correctAnswers;
}
