package tn.esprit.courzelo.entities.FeedBackEntities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Module;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Feedback")
public class Feedback {
    @Id
    private  String id;
    @Indexed
    private String description;
    @Indexed
    private TypeFeedback typeFeedback;
    @Indexed
    private int stateOfClass;
    @Indexed
    private int CourseContent;
    @Indexed
    private int audioVisualConnectivity;
    @Indexed
    private int classLecture;
    @DBRef
    private UserCourzelo student;
    @DBRef
    private UserCourzelo teacher;
    @DBRef
    private Module module;
    @DBRef
    private List<QuestionFeedback> questionFeedbacks;
}
