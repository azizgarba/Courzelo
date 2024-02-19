package tn.esprit.courzelo.entities.AcademicProgramEntities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import tn.esprit.courzelo.entities.SessionEntities.Session;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Class")
public class Class {
    @Id
    private  String id;
    @Indexed
    private String name;
    @DBRef
    private Level level;
    @DBRef
    private List<Session> Sessions;
    @DBRef
    private List<Session> sessions;
    @DBRef
    private List<UserCourzelo> students;
    @DBRef
    private List<UserCourzelo> teachers;
}
