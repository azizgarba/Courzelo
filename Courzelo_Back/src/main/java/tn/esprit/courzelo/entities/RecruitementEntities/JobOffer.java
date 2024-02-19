package tn.esprit.courzelo.entities.RecruitementEntities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "JobOffer")
public class JobOffer {
    @Id
    private  String id;
    @Indexed
    private String title;
    @Indexed
    private String description;
    @Indexed
    private String skills;
    @Indexed
    private String speciality;
    @Indexed
    private String experience;
    @DBRef
    private UserCourzelo recruiter;
    @DBRef
    private List<Candidacy> candidacies;
}
