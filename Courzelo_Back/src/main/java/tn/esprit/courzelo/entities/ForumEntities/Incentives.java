package tn.esprit.courzelo.entities.ForumEntities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "IncentivesForum")

public class Incentives {
    @Id
    private String id;
    @Indexed
    private  IncentivesType incentivesType;
    @Indexed
    private Date dateOFObtaining ;
    @Indexed
    private Date DeliberationDate;
    @DBRef
    @Indexed
    private UserCourzelo teacher;

}
