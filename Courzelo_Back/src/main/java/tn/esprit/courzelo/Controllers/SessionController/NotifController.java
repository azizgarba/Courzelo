package tn.esprit.courzelo.Controllers.SessionController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.courzelo.Services.SessionService.NotifServiceImpl;
import tn.esprit.courzelo.entities.SessionEntities.Event;
import tn.esprit.courzelo.entities.SessionEntities.Notif;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@Tag(name = "Notif")
@RequestMapping("/notif")
public class NotifController {

    private final NotifServiceImpl serv;

    @GetMapping("/show")
    public List<Notif> getAll(){
        return serv.Retrieve();
    }
}
