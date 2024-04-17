package tn.esprit.courzelo.Controllers.SessionController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.courzelo.Repositories.SessionRepo.NotifRepo;
import tn.esprit.courzelo.Services.SessionService.EventServiceImpl;
import tn.esprit.courzelo.entities.SessionEntities.Event;
import tn.esprit.courzelo.entities.SessionEntities.Notif;
import tn.esprit.courzelo.entities.SessionEntities.Session;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@Tag(name = "Event")
@RequestMapping("/event")
public class EventController {

    private final EventServiceImpl serv;
    private final NotifRepo repo;
    @PostMapping("/add")
    public Event add(@RequestBody Event session ){

        Notif notif = new Notif();
        notif.setEvent(session);
        serv.AddEvent(session);
        repo.save(notif);
        return session;
    }
    @PutMapping("/update")
    public Event Update(@RequestBody Event Event){
        return serv.Update(Event);
    }

    @GetMapping("/show/{id}")
    public Event Get(@PathVariable String id){
        return serv.Retrieve(id);
    }

    @GetMapping("/show")
    public List<Event> getAll(){
        return serv.Retrieve();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        serv.Delete(id);
    }


    @PostMapping("/stats")
    public Event getStats(@RequestBody Event event){
        return serv.GetEstimation(event);
    }

    @PostMapping("/estimations")
    public void getAllStats(){
        serv.GetAllEstimation();
    }

}
