package tn.esprit.courzelo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import tn.esprit.courzelo.entities.ForumEntities.Answer;
import tn.esprit.courzelo.entities.ForumEntities.ChatRoom;
import tn.esprit.courzelo.entities.ForumEntities.QuestionForum;
import tn.esprit.courzelo.entities.ForumEntities.Votes;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "User_c")
@JsonIgnoreProperties({"feedbackTeachers", "classes", "projects", "chatRoom", "questionForums", "answers", "votes"})
public class User_c {
@Id
private long id;
private String firstName;
private String lastName;
private String email;
private String password;
private String sexe;
private Date date_of_birth;
private Date date_of_creation;
private int nbMaxHeurePerWeek;
private int nbHourPerWeek=0;
private Role role;
private String companyName;
private String descriptionRecruiter;
private float scoreXp;
private String badge;
private String resume;
private Speciality speciality;
private String level;
private boolean approved=false;
private int validVoteCount=0;
private boolean canVote=true;
private int nbVoteForIncentives;
private int nbPrimeVoteForBadges;
private String PaymentDay;
private String CentreOffIntrest;
private Float overAll_average;
@DBRef
    private List<FeedbackTeacher> feedbackTeachers;
@DBRef
    private List<Class> classes;
@DBRef
    private List<Project> projects;
@DBRef
    private ChatRoom chatRoom;
@DBRef
    private List<QuestionForum> questionForums;
@DBRef
    private List<Answer> answers;
@DBRef
    private List<Votes> votes;

}
