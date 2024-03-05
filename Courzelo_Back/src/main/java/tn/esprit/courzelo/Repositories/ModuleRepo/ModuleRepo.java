package tn.esprit.courzelo.Repositories.ModuleRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Module;

public interface ModuleRepo extends MongoRepository<Module,String> {
    Module findModuleById(String id);
    Module findModuleByName(String Name);
}