package tn.esprit.courzelo.Repositories.ModuleRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.courzelo.entities.ForumEntities.QuestionForum;
import tn.esprit.courzelo.entities.Module;

public interface ModuleRepo extends MongoRepository<Module,String> {
}
