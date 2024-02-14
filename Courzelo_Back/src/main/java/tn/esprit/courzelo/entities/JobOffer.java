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
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "JobOffer")
public class JobOffer {
    @Id
    private long id;
    private String title;
    private String description;
    private String skills;
    private String speciality;
    private String experience;
    @DBRef
    private User_c recruiter;
    @DBRef
    private List<Candidacy> candidacies;
}
