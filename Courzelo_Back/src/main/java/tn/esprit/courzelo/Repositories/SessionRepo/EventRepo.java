package tn.esprit.courzelo.Repositories.SessionRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.courzelo.entities.SessionEntities.Event;

@Repository
public interface EventRepo extends MongoRepository<Event, String> {

    public Event findByName(String name);
}
