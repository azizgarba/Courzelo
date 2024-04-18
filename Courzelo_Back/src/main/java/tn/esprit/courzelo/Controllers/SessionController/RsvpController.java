package tn.esprit.courzelo.Controllers.SessionController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.courzelo.Repositories.SessionRepo.RsvpRepo;
import tn.esprit.courzelo.entities.SessionEntities.Notif;
import tn.esprit.courzelo.entities.SessionEntities.Rsvp;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@Tag(name = "Rsvp")
@RequestMapping("/rsvp")
public class RsvpController {

    private final RsvpRepo repo;

    @PostMapping("/add")
    public Rsvp Add(@RequestBody Rsvp rsvp){
        return repo.save(rsvp);
    }

}
