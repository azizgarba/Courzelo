package tn.esprit.courzelo.Repositories.SessionRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.courzelo.entities.SessionEntities.Session;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface SessionRepo extends MongoRepository<Session, String> {

}
