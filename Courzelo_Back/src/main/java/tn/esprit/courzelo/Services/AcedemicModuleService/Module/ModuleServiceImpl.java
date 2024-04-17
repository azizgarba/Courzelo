package tn.esprit.courzelo.Services.AcedemicModuleService.Module;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.courzelo.Repositories.ModuleRepo.ClassRepo;
import tn.esprit.courzelo.Repositories.ModuleRepo.EducationalProgramRepo;
import tn.esprit.courzelo.Repositories.ModuleRepo.ModuleRepo;
import tn.esprit.courzelo.Repositories.UserRepo.UserRepo;
import tn.esprit.courzelo.Services.AcedemicModuleService.Module.IModuleservice;
import tn.esprit.courzelo.entities.AcademicProgramEntities.*;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Class;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Module;
import tn.esprit.courzelo.entities.UserCorzelo.Role;
import tn.esprit.courzelo.entities.UserCorzelo.Speciality;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ModuleServiceImpl  implements IModuleservice {
    private final ModuleRepo moduleRepo ;
    private final ClassRepo classRepo ;
    private final UserRepo userRepo ;

    @Override
    public List<Module> getAllModules() {
        return moduleRepo.findAll();
    }



    public UserCourzelo findAvailableTeacher(List<UserCourzelo> teachers, Module module) {
        for (UserCourzelo teacher : teachers) {
            if (teacher.getNbMaxHeurePerWeek() >= module.getNbHeureTotal()) {
                return teacher;
            }
        }
        return null;
    }

    @Override
    public void assignTeachersToClass(Class moduleClass, Module selectedModule) {
        // The logic for assigning teachers to the class based on the added module
        List<UserCourzelo> matchingTeachers = userRepo.findUserCourzeloByRoleAndSpecialityAndModule(
                Role.Teacher, Speciality.valueOf(selectedModule.getName().toUpperCase()), selectedModule.getName()
        );


        // Debug log
        System.out.println("Matching teachers: " + matchingTeachers);

        UserCourzelo availableTeacher = findAvailableTeacher(matchingTeachers, selectedModule);

        System.out.println("Selected module: " + selectedModule);
        System.out.println("Available teacher: " + availableTeacher);

        if (availableTeacher != null) {
            // Affecter l'enseignant à la classe
            moduleClass.getTeachers().add(availableTeacher);

            // Mettre à jour les heures du professeur et de la classe
            availableTeacher.setNbMaxHeurePerWeek(availableTeacher.getNbMaxHeurePerWeek() - selectedModule.getNbHeureTotal());

            for (Module module : moduleClass.getModules()) {
                if (module.getName().equals(selectedModule.getName())) {
                    module.setNbHeureTotal(module.getNbHeureTotal() - selectedModule.getNbHeureTotal());
                    break;
                }
            }

            // Mettre à jour la liste des enseignants (supprimer l'enseignant déjà affecté)
            matchingTeachers.remove(availableTeacher);
        } else {
            // Gérer le cas où aucun enseignant n'est disponible
            String errorMessage = "Aucun enseignant n'est disponible pour le module " + selectedModule.getName();
            // Log the error message
            System.out.println("Error message: " + errorMessage);
            // Vous pouvez gérer cette exception selon les besoins de votre application
            throw new RuntimeException(errorMessage);
        }
    }

    @Override
    public Module addModuleToClasses(Module module, List<String> classIds,String semestreString) {

// Convert the string to Semestre enum
        Semestre semestre = Semestre.valueOf(semestreString);

        Module newModule = moduleRepo.save(module);
        // Fetch the classes based on classIds
        List<Class> classes = classRepo.findAllById(classIds);
        // Check if all classes were found
        if (classes.size() != classIds.size()) {
            throw new IllegalArgumentException("One or more classes not found");
        }
        // Associate the module with each class
        for (Class aClass : classes) {
            if (aClass.getModules() == null) {
                aClass.getId();
                aClass.setModules(new ArrayList<>());
            }
            aClass.getModules().add(newModule);
            log.info("Module added to class: {} | Modules: {}", aClass.getName(), aClass.getModules());
            // Assign teachers to the class based on the added module
           // assignTeachersToClass(aClass, newModule);
        }
        // Update the classes in the module entity
        newModule.setClasses(classes);
        // Set the chosen semester for the module
        newModule.setSemestre(semestre);
        // Save the updated classes
        classRepo.saveAll(classes);
        // Save the updated module
        return moduleRepo.save(newModule);
    }


        @Override
    public void removeModule(String id) {
        {
            moduleRepo.deleteById(id);
        }
    }
    @Override
    public Module updateModule(Module module) {
        return moduleRepo.save(module);
    }
    @Override
    public List<Module> searchModules(String name) {
        return moduleRepo.findAll().stream()
                .filter(module ->
                        name == null || module.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    @Override
    public Module getById(String id) {
        return moduleRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("no  id " + id));
    }






}