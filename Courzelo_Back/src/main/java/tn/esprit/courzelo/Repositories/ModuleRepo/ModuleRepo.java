package tn.esprit.courzelo.Repositories.ModuleRepo;

import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Class;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Module;
import tn.esprit.courzelo.entities.EvaluationEntities.Test;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Semestre;
import java.util.List;
import java.util.Optional;
public interface ModuleRepo extends MongoRepository<Module,String> {
    Module findModuleById(String id);
    Module findModuleByName(String Name);

    Module findModuleByTests(Test test);
    Module findModuleByLevelName(String name);
    @Override
    <S extends Module> List<S> findAll(Example<S> example);

    List<Module> findModuleByClassesAndSemestre(Class C, Semestre semestre);
    List<Module> findModuleByClasses (Class C);
        Module findByName(String moduleName);
}

