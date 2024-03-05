package tn.esprit.courzelo.entities.ForumEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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


public class Message {


    private Date time ;

    private String replymessage;


    private String sendermessage;
    private String replyMedia;
    private Media replyMediaContent ;





}
