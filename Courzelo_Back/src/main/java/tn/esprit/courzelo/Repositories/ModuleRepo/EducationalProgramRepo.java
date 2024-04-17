package tn.esprit.courzelo.Repositories.ModuleRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.courzelo.entities.AcademicProgramEntities.EducationalProgram;

public interface EducationalProgramRepo extends MongoRepository<EducationalProgram,String> {
}
