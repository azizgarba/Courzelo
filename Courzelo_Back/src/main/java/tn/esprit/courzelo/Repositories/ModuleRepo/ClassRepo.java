package tn.esprit.courzelo.Repositories.ModuleRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Class;

import java.util.List;
import java.util.Optional;

public interface ClassRepo extends MongoRepository<Class,String> {

    Class findByName(String name);
    List<Class> findAllByNameIn(List<String> name);


}
