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
@Document(collection = "QuestionForum")
@JsonIgnoreProperties({ "answers"})
public class QuestionForum {
    @Id
    private long id;
    private String title;
    private String description;
    @DBRef
    private User_c student;
    @DBRef
    private Module module;
    @DBRef
    private List<Answer> answers;
}
