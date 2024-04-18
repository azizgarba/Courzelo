package tn.esprit.courzelo.Repositories.SessionRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.courzelo.entities.SessionEntities.Notif;

@Repository
public interface NotifRepo extends MongoRepository<Notif, String> {
}
