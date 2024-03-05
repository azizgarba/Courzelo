package tn.esprit.courzelo.Services.ForumService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.courzelo.Repositories.ForumRepo.ChatRepository;
import tn.esprit.courzelo.Repositories.UserRepo.UserRepo;

import tn.esprit.courzelo.entities.ForumEntities.ChatRoom;
import tn.esprit.courzelo.entities.ForumEntities.MediaType;
import tn.esprit.courzelo.entities.ForumEntities.Message;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
@AllArgsConstructor
public class ChatServiceImpl {
    private SequenceGeneratorService sequenceGeneratorService;
    private UserRepo userRepo;
    private ChatRepository chatRepository;
    private MediaServiceImpl mediaService ;
    private static final Logger LOGGER = LoggerFactory.getLogger(ChatServiceImpl.class);

    public ChatRoom addChat(ChatRoom chat, String idSender, String idReceiver) {
        UserCourzelo sender = userRepo.findUserCourzeloById(idSender);
        UserCourzelo receiver = userRepo.findUserCourzeloById(idReceiver);
        chat.setId(sequenceGeneratorService.generateSequence(ChatRoom.SEQUENCE_NAME));
        if (sender != null && receiver != null) {
            chat.setSender(sender);
            chat.setReceiver(receiver);
            return chatRepository.save(chat);
        }
        return null;
    }

    public void deleteChatById(int id) {
        chatRepository.deleteById(id);
    }

    public ChatRoom getChatById(int id) {
        return chatRepository.findById(id).orElse(null);

    }

    public HashSet<ChatRoom> getChatsByUser(String userId) throws ChatNotFoundException {
        UserCourzelo u= userRepo.findUserCourzeloById(userId);
        HashSet<ChatRoom> chat = chatRepository.findChatRoomByReceiver(u);
        HashSet<ChatRoom> chat1 = chatRepository.findChatRoomBySender(u);

        chat1.addAll(chat);

        if (chat.isEmpty() && chat1.isEmpty()) {
            throw new ChatNotFoundException();
        } else if (chat1.isEmpty()) {
            return chat;
        } else {
            return chat1;
        }
    }

    public ChatRoom getChatBySenderAndReceiver(String idSender, String idReceiver) {
        UserCourzelo sender = userRepo.findUserCourzeloById(idSender);
        UserCourzelo receiver = userRepo.findUserCourzeloById(idReceiver);
        return chatRepository.findChatRoomBySenderAndReceiver(sender, receiver);

    }
    public ChatRoom getChatBySenderAndReceiver2( String idReceiver,String idSender) {
        UserCourzelo sender = userRepo.findUserCourzeloById(idSender);
        UserCourzelo receiver = userRepo.findUserCourzeloById(idReceiver);
        return chatRepository.findChatRoomByReceiverAndSender(receiver,sender);

    }


    public ChatRoom addMessage(Message message, int chatId, String idSender) throws ChatNotFoundException, UserNotFoundException {
        // Récupérer l'utilisateur expéditeur
        UserCourzelo sender = userRepo.findUserCourzeloById(idSender);
        if (sender == null) {
            throw new UserNotFoundException("User not found with ID: " + idSender);
        }
        if (chatId== 0) {
            throw new UserNotFoundException("chat not found with ID: " + chatId);
        }

        // Récupérer la salle de discussion
        Optional<ChatRoom> chatOptional = chatRepository.findById(chatId);
        ChatRoom chatRoom = chatOptional.orElseThrow(ChatNotFoundException::new);

        // Assurer que le message a un expéditeur et une heure valide
       


        // Ajouter le message à la salle de discussion
        List<Message> messages = chatRoom.getMessages();
        if (messages == null) {
            messages = new ArrayList<>();
        }
        message.setSendermessage(sender.getFirstName());
        message.setTime(new Date());
        messages.add(message);
        chatRoom.setMessages(messages);

        // Sauvegarder la salle de discussion mise à jour
        ChatRoom savedChatRoom = chatRepository.save(chatRoom);

        // Logging
        LOGGER.debug("Message added to chat room: {}", savedChatRoom.getId());
        LOGGER.debug("Sender: {}", sender);

        return savedChatRoom;
    }

    public ChatRoom addMediaMessage(Message message, int chatId, MultipartFile image, String fileType, String userId, MediaType mediaType) throws ChatNotFoundException, UserNotFoundException {
        // Récupérer l'utilisateur expéditeur
        UserCourzelo sender = userRepo.findUserCourzeloById(userId);
        if (sender == null) {
            throw new UserNotFoundException("User not found with ID: " + userId);
        }
        if (chatId == 0) {
            throw new ChatNotFoundException();
        }

        // Récupérer la salle de discussion
        Optional<ChatRoom> chatOptional = chatRepository.findById(chatId);
        ChatRoom chatRoom = chatOptional.orElseThrow(ChatNotFoundException::new);

        // Assurer que le message a un expéditeur et une heure valide
        message.setSendermessage(sender.getFirstName());
        message.setTime(new Date());

        // Ajouter le média au message
        String uploadedMediaId = null;
        try {
            uploadedMediaId = this.mediaService.uploadMessageMedia(chatId, image, mediaType, userId, fileType);
        } catch (Exception e) {
            // Gérer l'exception, par exemple, journalisation ou traitement spécifique
            // Vous pouvez remplacer cette gestion d'erreur par celle qui convient à votre cas
            e.printStackTrace();

        }
        message.setReplyMedia(uploadedMediaId);
        message.setReplymessage(null);

        // Ajouter le message à la salle de discussion
        List<Message> messages = chatRoom.getMessages();
        if (messages == null) {
            messages = new ArrayList<>();
        }
        messages.add(message);
        chatRoom.setMessages(messages);

        // Sauvegarder la salle de discussion mise à jour
        ChatRoom savedChatRoom = chatRepository.save(chatRoom);

        // Logging
        LOGGER.debug("Message with media added to chat room: {}", savedChatRoom.getId());
        LOGGER.debug("Sender: {}", sender);

        return savedChatRoom;
    }

}





