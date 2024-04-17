package tn.esprit.courzelo.Controllers.AcademicModule;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.courzelo.Services.AcedemicModuleService.Educational.IEducationalService;
import tn.esprit.courzelo.Services.AcedemicModuleService.Module.IModuleservice;
import tn.esprit.courzelo.entities.AcademicProgramEntities.EducationalProgram;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Semestre;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Module;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@Tag(name = "EducationalProgram")
public class EducationalProgramController {
    private final IEducationalService EducationalService;
    private final IModuleservice moduleservice;


    @GetMapping("/listofPrograms")
    public List<EducationalProgram> getAllPrograms() {
        return EducationalService.getAllPrograms();
    }

    @GetMapping("/class/{className}/semester/{semester}")
    public List<Module> getModulesByClassNameAndSemester(
            @PathVariable String className,
            @PathVariable Semestre semester) {
        return EducationalService.getModulesByClassNameAndSemester(className, semester);
    }
//hethi function
    @GetMapping("/classs/{className}")
    public List<Module> getModules(
            @PathVariable String className) {
        return EducationalService.getModules(className);
    }
}
