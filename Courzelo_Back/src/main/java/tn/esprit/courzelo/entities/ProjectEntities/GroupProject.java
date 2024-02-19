package tn.esprit.courzelo.entities.ProjectEntities;

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
@Document(collection = "GroupProject")
public class GroupProject {
    @Id
    private  String id;
    @Indexed
    private String nameOfProject;
    @Indexed
    private int number;
    private List<UserCourzelo> students;
    @DBRef
    private Project project;
}
