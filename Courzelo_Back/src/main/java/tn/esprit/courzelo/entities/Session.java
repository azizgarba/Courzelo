package tn.esprit.courzelo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Session")
public class Session {
    @Id
    private long id;
    private Date date;
    private String startTime;
    private String endTime;
    private String ConferenceLink;
    private List<User_c> participants;
    @DBRef
    private Class aClass;

}
