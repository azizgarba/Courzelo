package tn.esprit.courzelo.Services.AcedemicModuleService.Module;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Class;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Module;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Semestre;

import java.util.List;


public interface IModuleservice {

    List<Module> getAllModules();
    Module addModuleToClasses(Module module, List<String> classIds,String semestre);
    void removeModule (String id );
    Module updateModule(Module module) ;
    List<Module> searchModules(String name);
    Module getById(String id);
    void assignTeachersToClass(Class moduleClass, Module selectedModule);
}

