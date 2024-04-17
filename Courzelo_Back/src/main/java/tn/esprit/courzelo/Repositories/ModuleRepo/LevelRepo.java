package tn.esprit.courzelo.Repositories.ModuleRepo;


import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Level;

import java.util.List;

public interface LevelRepo extends MongoRepository<Level,String> {



}
