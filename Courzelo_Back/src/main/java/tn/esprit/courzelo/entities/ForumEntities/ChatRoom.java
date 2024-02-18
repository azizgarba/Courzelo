package tn.esprit.courzelo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "ChatRoom")
public class ChatRoom {
    @Id
    private long id;
    private User_c sender;
    private User_c receiver;
    @DBRef
    private List<Message> messages;
    @DBRef
    private List<User_c> senders;
    @DBRef
    private List<User_c> receivers;
}
