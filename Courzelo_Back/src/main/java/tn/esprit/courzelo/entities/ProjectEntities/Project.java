package tn.esprit.courzelo.entities.ProjectEntities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import tn.esprit.courzelo.entities.UserCorzelo.Speciality;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;
import java.util.Set;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Project")
public class Project {
    @Id
    private String id;
    @Indexed
    private String name;
    @Indexed
    private String description;
    @Indexed
    private Difficulty difficulty;

    private Set<Speciality> specialities;
    @Indexed
    private Date datedebut;
    @Indexed
    private Date deadline;
    @Indexed
    private int number;
    @Indexed
    private boolean hasGroupProject;

    @DBRef
    private List<Tasks> tasks;
    @DBRef
    private List<UserCourzelo> users;
    @DBRef
    private List<GroupProject> groupProjects;


}
