package tn.esprit.courzelo.Repositories.AcademicProgramRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Class;

@Repository
public interface ClassRepo extends MongoRepository<Class, String> {
}
