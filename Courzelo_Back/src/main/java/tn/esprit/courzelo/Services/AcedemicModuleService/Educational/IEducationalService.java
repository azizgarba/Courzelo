package tn.esprit.courzelo.Services.AcedemicModuleService.Educational;


import tn.esprit.courzelo.entities.AcademicProgramEntities.EducationalProgram;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Module;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Semestre;


import java.util.List;
import java.util.Map;

public interface IEducationalService {

    List<EducationalProgram> getAllPrograms();
    List<Module> getModulesByClassName(String name);
    List<Module> getModulesByClassNameAndSemester(String idClass, Semestre semester);
    List<Module> getModules(String idClass);

}
