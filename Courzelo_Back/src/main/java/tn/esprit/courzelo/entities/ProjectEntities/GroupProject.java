package tn.esprit.courzelo.entities.ProjectEntities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import tn.esprit.courzelo.Repositories.UserRepo.RoleRepository;
import tn.esprit.courzelo.entities.UserCorzelo.ERole;
import tn.esprit.courzelo.entities.UserCorzelo.Role;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "GroupProject")
public class GroupProject {
    @Id
    private  String id;
    @Indexed
    private String name;
    @DBRef
    private UserCourzelo student;
    @DBRef
    private List<UserCourzelo> students;
    @DBRef
    private Project project;

    @DBRef
    private List<Tasks> tasks;




    // Method to add a student to the group

}
