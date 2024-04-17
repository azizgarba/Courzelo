package tn.esprit.courzelo.entities.AcademicProgramEntities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "EducationalProgram")
public class EducationalProgram {
    @Id
    private  String id;
    @Indexed
    private String name;
    @Indexed
    private String description;
    private String year;
    @DBRef
    private UserCourzelo Teacher ;
    @DBRef
    @JsonIgnore
    private List<Module> modules;
    @Indexed
    private boolean isActive;
    @DBRef
    private Class Classes;





}
