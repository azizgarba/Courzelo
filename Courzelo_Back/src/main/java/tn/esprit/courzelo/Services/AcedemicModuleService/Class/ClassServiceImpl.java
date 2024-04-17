package tn.esprit.courzelo.Services.AcedemicModuleService.Class;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.courzelo.Repositories.ModuleRepo.ClassRepo;
import tn.esprit.courzelo.Repositories.ModuleRepo.LevelRepo;
import tn.esprit.courzelo.Repositories.ModuleRepo.ModuleRepo;
import tn.esprit.courzelo.Repositories.UserRepo.UserRepo;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Class;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Course;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Level;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Module;
import tn.esprit.courzelo.entities.UserCorzelo.Role;
import tn.esprit.courzelo.entities.UserCorzelo.Speciality;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor

public class ClassServiceImpl implements IClassService {
    private final  ClassRepo classRepo;
    private final LevelRepo levelRepo;
    private final UserRepo userRepo;
    private final ModuleRepo moduleRepo;
    @Override
    public List<Class> GetClasses() {
        return classRepo.findAll();
    }

    private UserCourzelo findAvailableTeacher(List<UserCourzelo> teachers, Module module) {
        for (UserCourzelo teacher : teachers) {
            if (teacher.getNbMaxHeurePerWeek() >= module.getNbHeureTotal()) {
                return teacher;
            }
        }
        return null;
    }


    private void assignTeacherToClass(Class moduleClass, String moduleName) {
        // Rechercher le module sélectionné
        Module selectedModule = moduleRepo.findByName(moduleName);

        if (selectedModule != null) {
            List<UserCourzelo> matchingTeachers = userRepo.findUserCourzeloByRoleAndSpecialityAndModule(
                    Role.Teacher, Speciality.valueOf(selectedModule.getName().toUpperCase()), selectedModule.getName()
            );
            // Rechercher le premier enseignant disponible
            UserCourzelo availableTeacher = findAvailableTeacher(matchingTeachers, selectedModule);

            if (availableTeacher != null) {
                // Affecter l'enseignant à la classe
                moduleClass.getTeachers().add(availableTeacher);

                // Mettre à jour les heures du professeur et de la classe
                // Update the User entity based on your actual entity structure
                availableTeacher.setNbMaxHeurePerWeek(availableTeacher.getNbMaxHeurePerWeek() - selectedModule.getNbHeureTotal());

                for (Module module : moduleClass.getModules()) {
                    if (module.getName().equals(selectedModule.getName())) {
                        module.setNbHeureTotal(module.getNbHeureTotal() - selectedModule.getNbHeureTotal());
                        break;  // assuming each module has a unique name; adjust the condition accordingly
                    }
                }
                // Mettre à jour la liste des enseignants (supprimer l'enseignant déjà affecté)
                matchingTeachers.remove(availableTeacher);
            } else {
                // Gérer le cas où aucun enseignant n'est disponible
                String errorMessage = "Aucun enseignant n'est disponible pour le module " + moduleName;
                // You can log the error message or handle it according to your application's requirements
                System.out.println(errorMessage);
            }
        }
    }


    @Override
    public Class addClassAndAssignToLevel(Class aClass, String id ) {
        Class savedClass = classRepo.save(aClass);
        Level level = levelRepo.findById(id).orElseThrow(() ->
                new IllegalArgumentException("No Level Found with this id " +id));
        savedClass.setLevel(level);
        // Assign teachers to the class for the specified module
       // assignTeacherToClass(savedClass, moduleName);
        classRepo.save(savedClass);
        return savedClass;
    }

    @Override
    public void removeClass(String id) {
        classRepo.deleteById(id);
    }


    @Override
    public Class updateClass(Class aClass) {
        return classRepo.save(aClass);
    }

    @Override
    public Class getById(String id) {
        return classRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("no  id " + id));
    }



    }






