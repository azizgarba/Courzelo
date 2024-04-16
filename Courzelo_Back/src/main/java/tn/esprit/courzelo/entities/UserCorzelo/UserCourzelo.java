package tn.esprit.courzelo.entities.UserCorzelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import tn.esprit.courzelo.entities.EvaluationEntities.Evaluation;
import tn.esprit.courzelo.entities.EvaluationEntities.Test;
import tn.esprit.courzelo.entities.FeedBackEntities.Feedback;
import tn.esprit.courzelo.entities.ForumEntities.Answer;
import tn.esprit.courzelo.entities.ForumEntities.ChatRoom;
import tn.esprit.courzelo.entities.ForumEntities.Votes;
import tn.esprit.courzelo.entities.ForumEntities.QuestionForum;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Class;
import tn.esprit.courzelo.entities.ProjectEntities.Project;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "UserCourzelo")
@JsonIgnoreProperties({"feedbackTeachers", "classes", "projects", "chatRoom", "questionForums", "answers", "votes"})
        public class UserCourzelo {

        @Id
        private  String id;
        @Indexed
        private String firstName;
        @Indexed
        private String lastName;
        @Indexed
        private String email;
        @Indexed
        private String password;
        @Indexed
        private String sexe;
        @Indexed
        private Date date_of_birth;
        @Indexed
        private Date date_of_creation;
        @Indexed
        private int nbMaxHeurePerWeek;
        @Indexed
        private int nbHourPerWeek=0;
        @Indexed
        private Role role;
        @Indexed
        private String companyName;
        @Indexed
        private String descriptionRecruiter;
        @Indexed
        private float scoreXp;
        @Indexed
        private List<badgeType> badges;
        @Indexed
        private String resume;
        @Indexed
        private Speciality speciality;
        @Indexed
        private int level =1 ;
        @Indexed
        private boolean approved=false;
        @Indexed
        private int validVoteCount=0;
        @Indexed
        private boolean canVote=true;
        @Indexed
        private int nbVoteForIncentives;
        @Indexed
        private int nbPrimeVoteForBadges;
        @Indexed
        private String PaymentDay;
        @Indexed
        private String CentreOffIntrest;
        @Indexed
        private Float overAll_average;
        @DBRef
        private List<Feedback> feedback;
        @DBRef
        private Class classe;
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



