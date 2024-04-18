package tn.esprit.courzelo.Controllers.SessionController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.courzelo.Services.SessionService.SessionServiceImpl;
import tn.esprit.courzelo.entities.SessionEntities.Session;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@Tag(name = "Session")
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private final SessionServiceImpl serv;

    @PostMapping("/add")
    public Session add(@RequestBody Session session ){
        return serv.AddSession(session);
    }
    @PutMapping("/update")
    public Session Update(@RequestBody Session session){
        return serv.Update(session);
    }

    @GetMapping("/show/{id}")
    public Session Get(@PathVariable String id){
        return serv.Retrieve(id);
    }

    @GetMapping("/show")
    public List<Session> getAll(){
        return serv.Retrieve();
    }

    @PostMapping("/showSchedule")
    public List<Session> getAll(@RequestBody String name){
        return serv.RetrieveByClass(name);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        serv.Delete(id);
    }

    @PostMapping("/generate")
    public void generate(@RequestBody String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

        // Parse the string to LocalDateTime using the formatter
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        serv.createScedule(dateTime);
    }
}
