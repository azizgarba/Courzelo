package tn.esprit.courzelo.entities.ForumEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import tn.esprit.courzelo.entities.ForumEntities.QuestionForum;
import tn.esprit.courzelo.entities.UserCorzelo.*;
import tn.esprit.courzelo.entities.ForumEntities.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "AnswerForum")
@JsonIgnoreProperties({ "votes"})
public class Answer {
    @Id
    private String id;
    @Indexed
    private String message;
    @Indexed
    private int nbr_vote;
    @Indexed
    private boolean getBudget;
    @Indexed
    private Date date ;
    @Indexed
    @DBRef
    private QuestionForum questionForum;
    @Indexed
    @DBRef
    private UserCourzelo user;

    @DBRef
    private List<Votes> votes;
}
