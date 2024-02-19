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

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "ChatRoom")
public class ChatRoom {
    @Id
    private String id;
    @Indexed
    private UserCourzelo sender;
    @Indexed
    private UserCourzelo receiver;
    @DBRef
    private List<Message> messages;
    @DBRef
    private List<UserCourzelo> senders;
    @DBRef
    private List<UserCourzelo> receivers;
}
