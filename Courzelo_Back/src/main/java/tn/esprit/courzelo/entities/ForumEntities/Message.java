package tn.esprit.courzelo.entities.ForumEntities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Message")
public class Message {
    @Id
    private String id;
    @Indexed
    private String time;
    @Indexed
    private String replyMessage;
    @Indexed
    private String senderEmail;

    @DBRef
    @Indexed
    private ChatRoom chatRoom;
}
