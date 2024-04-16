package tn.esprit.courzelo.Repositories.ModuleRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Module;
import tn.esprit.courzelo.entities.EvaluationEntities.Test;

public interface ModuleRepo extends MongoRepository<Module,String> {
    Module findModuleByTests(Test test);
    Module findModuleByLevelName(String name);
}

