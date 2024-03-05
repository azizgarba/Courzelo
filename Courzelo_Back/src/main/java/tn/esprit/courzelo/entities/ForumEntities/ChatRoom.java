package tn.esprit.courzelo.entities.ForumEntities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "ChatRoom")
public class ChatRoom {
    @Transient
    public static final String SEQUENCE_NAME = "chat_sequence";
    @Id
    private int id;
    @DBRef
    @Indexed
    private UserCourzelo sender;
    @DBRef
    @Indexed
    private UserCourzelo receiver;

    @Indexed
    private List<Message> messages = new ArrayList<>();;




}
