package tn.esprit.courzelo.Controllers.SessionController;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.courzelo.entities.SessionEntities.Notif;

@RestController
public class NotificationController {

    private SimpMessagingTemplate template;
    private Notif notif = new Notif();
    @GetMapping("/notify")
    public String getNotification(){
        notif.setMessageContent("test Notif");
        template.convertAndSend("/topic/notification",notif);
        return "Notification succesfully sent to angular";
    }
}
