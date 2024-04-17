package tn.esprit.courzelo.Services.AcedemicModuleService.Educational;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.courzelo.Repositories.ModuleRepo.ClassRepo;
import tn.esprit.courzelo.Repositories.ModuleRepo.EducationalProgramRepo;
import tn.esprit.courzelo.Repositories.ModuleRepo.ModuleRepo;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Class;
import tn.esprit.courzelo.entities.AcademicProgramEntities.EducationalProgram;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Module;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Semestre;

import java.util.*;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class EducationalServiceImpl implements IEducationalService {
    private final EducationalProgramRepo educationalProgramRepo ;
    private  final ModuleRepo moduleRepo;
    private  final ClassRepo classRepo;
    @Override

    public List<EducationalProgram> getAllPrograms() {
        return educationalProgramRepo.findAll();
    }

    @Override
    public List<Module> getModulesByClassName(String name) {
        Class targetClass = classRepo.findByName(name);
        if (targetClass == null) {
            // Handle the case where the class does not exist
            return null;
        }

        List<Module> allModules = moduleRepo.findAll();

        // Filter modules for the given class
        List<Module> classModules = allModules.stream()
                .filter(module -> targetClass.getModules().contains(module))
                .collect(Collectors.toList());

        return classModules;
    }

    @Override
    public List<Module> getModulesByClassNameAndSemester(String idClass, Semestre semester) {
       Class C = classRepo.findByName(idClass);
        List<Module> m =moduleRepo.findModuleByClassesAndSemestre(C,semester);
        if (m == null) {
            return null;
        }
     else return m;
    }

    @Override
    public List<Module> getModules(String idClass) {

        Class C = classRepo.findByName(idClass);
        List<Module> m =moduleRepo.findModuleByClasses(C);

        if (m == null) {
            return null;
        }
        else return m;

    }
}









