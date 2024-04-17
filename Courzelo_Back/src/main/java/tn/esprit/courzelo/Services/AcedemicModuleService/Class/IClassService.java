package tn.esprit.courzelo.Services.AcedemicModuleService.Class;

import tn.esprit.courzelo.entities.AcademicProgramEntities.Class;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Level;

import java.util.List;

public interface IClassService {

    List<Class> GetClasses();
    Class addClassAndAssignToLevel(Class aClass, String id );
    void removeClass (String id );
    Class updateClass(Class aClass);
    Class getById(String id);

}
