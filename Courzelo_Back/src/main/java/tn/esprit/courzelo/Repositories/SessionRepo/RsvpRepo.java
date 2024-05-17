package tn.esprit.courzelo.Repositories.SessionRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.courzelo.entities.SessionEntities.Event;
import tn.esprit.courzelo.entities.SessionEntities.Rsvp;

import java.util.List;


@Repository
public interface RsvpRepo extends MongoRepository<Rsvp, String> {

    //public List<Rsvp> findRsvpsByEvent(Event event);
}
