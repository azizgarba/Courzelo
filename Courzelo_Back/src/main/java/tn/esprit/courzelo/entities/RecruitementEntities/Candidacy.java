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
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Candidacy")
public class Candidacy {
    @Id
    private  String id;
    @Indexed
    private String description;
    @Indexed
    private String skills;
    @Indexed
    private String experience;
    @Indexed
    private String resume_candidacy;
    @DBRef
    private UserCourzelo student;
    @DBRef
    private List<JobOffer> jobOffers;

}
