package tn.esprit.courzelo.entities;

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
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Candidacy")
public class Candidacy {
    @Id
    private long id;
    private String description;
    private String skills;
    private String experience;
    private String resume_candidacy;
    @DBRef
    private User_c student;
    @DBRef
    private List<JobOffer> jobOffers;

}
