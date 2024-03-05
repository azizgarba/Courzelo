package tn.esprit.courzelo.Repositories.ForumRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.courzelo.entities.ForumEntities.Answer;
import tn.esprit.courzelo.entities.ForumEntities.ChatRoom;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.HashSet;
import java.util.List;

public interface ChatRepository extends MongoRepository<ChatRoom, Integer> {

    HashSet<ChatRoom> findChatRoomByReceiver(UserCourzelo receiver);
    HashSet<ChatRoom> findChatRoomBySender(UserCourzelo receiver);

    ChatRoom findChatRoomBySenderAndReceiver(UserCourzelo sender,UserCourzelo receiver);
    ChatRoom findChatRoomByReceiverAndSender(UserCourzelo receiver,UserCourzelo sender);
}
