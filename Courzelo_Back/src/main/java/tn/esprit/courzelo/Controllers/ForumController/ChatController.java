package tn.esprit.courzelo.Controllers.ForumController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.courzelo.Services.ForumService.ChatNotFoundException;
import tn.esprit.courzelo.Services.ForumService.ChatServiceImpl;
import tn.esprit.courzelo.Services.ForumService.MediaServiceImpl;
import tn.esprit.courzelo.Services.ForumService.UserNotFoundException;
import tn.esprit.courzelo.entities.ForumEntities.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.HashSet;
import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name = "ForumChat")
@RequestMapping("/ForumChat")
public class ChatController {
    private ChatServiceImpl chatService;
    private MediaServiceImpl mediaService ;
    private SimpMessagingTemplate messagingTemplate;

    @PostMapping("/createChat/{senderId}/{receiverId}")
    public ChatRoom createChat(@RequestBody ChatRoom c, @PathVariable String senderId, @PathVariable String receiverId) {
        return chatService.addChat(c, senderId, receiverId);

    }

    @GetMapping("/{id}")
    public ChatRoom getChatById(@PathVariable int id) {
        return chatService.getChatById(id);
    }

    @DeleteMapping("/{id}")
    public Void deleteChatById(@PathVariable int id) {
        chatService.deleteChatById(id);

        return null;
    }

    //For teacher
    @GetMapping("/getAllChatsByUser/{idUser}")
    public HashSet<ChatRoom> getAllChatBySender(@PathVariable String idUser) throws ChatNotFoundException {
        return chatService.getChatsByUser(idUser);

    }
    @GetMapping("/getChatBySenderAndReceiver/{idSender}/{idReceiver}")
    public ChatRoom getChatBySenderAndRceiver(@PathVariable String idSender,@PathVariable String idReceiver ) {
        return chatService.getChatBySenderAndReceiver(idSender,idReceiver);
    }
    @GetMapping("get/getChatBySenderAndReceiver/{idReceiver}/{idSender}")
    public ChatRoom getChatBySenderAndRceiver2(@PathVariable String idReceiver,@PathVariable String idSender ) {
        return chatService.getChatBySenderAndReceiver2(idReceiver,idSender);
    }
    /*@PostMapping("/SendMessage/{chatId}/{senderId}")
    public ChatRoom createMessage(@RequestBody Message msg, @PathVariable int chatId,@PathVariable String senderId ) throws ChatNotFoundException, UserNotFoundException {
        return  chatService.addMessage(msg,chatId,senderId);

    }*/
    /*@MessageMapping("/hello")
    @SendTo("/topic/greetings")
    @PutMapping("/message/{chatId}/{senderId}")
    public ResponseEntity<ChatRoom> addMessage (@RequestBody Message add, @PathVariable int chatId, @PathVariable String senderId)

            throws ChatNotFoundException, UserNotFoundException, InterruptedException {
        Thread.sleep(1000);
        return new ResponseEntity<ChatRoom>(chatService.addMessage(add, chatId,senderId), org.springframework.http.HttpStatus.OK);
    }*/
    @MessageMapping("/message") // Le point de terminaison pour les messages entrants
    @SendTo("/topic/greetings")// Le sujet auquel envoyer la réponse
    @PutMapping("/message/{chatId}/{senderId}") // Le point de terminaison REST pour ajouter un message
    public ResponseEntity<ChatRoom> addMessage(@RequestBody Message add, @PathVariable int chatId, @PathVariable String senderId)
            throws ChatNotFoundException, UserNotFoundException, InterruptedException {
        Thread.sleep(1000);
        ChatRoom updatedChatRoom = chatService.addMessage(add, chatId, senderId);

        // Vous pouvez également envoyer un message supplémentaire avec les détails du nouveau message ajouté
        String notificationMessage = "New message added by " + senderId + " in chat " + chatId;

        // Envoyer le message aux abonnés du sujet WebSocket
        messagingTemplate.convertAndSend("/topic/greetings", notificationMessage);


        // Envoyer le message aux abonnés du sujet WebSocket
        return new ResponseEntity<>(updatedChatRoom, HttpStatus.OK);
    }

    @PostMapping("/media/message")
    public ResponseEntity<ChatRoom> addMediaMessage(@RequestParam int chatId,
                                                @RequestParam MultipartFile image, @RequestParam String fileType, @RequestParam String username)
            throws ChatNotFoundException, Exception, UserNotFoundException {
        Message message = new Message();
        message.setSendermessage(username);
        return new ResponseEntity<ChatRoom>(
                chatService.addMediaMessage(message, chatId, image, fileType, username, MediaType.SHARED_MEDIA),
                org.springframework.http.HttpStatus.OK);
    }
    @GetMapping("media/{id}")
    public Media getMediaById(@PathVariable String id) {
        return mediaService.getMediaById(id);
    }


}
