package tn.esprit.courzelo.Controllers.AcademicModule;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.courzelo.Services.AcedemicModuleService.Module.IModuleservice;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Level;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Module;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Semestre;

import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name = "Module")
public class ModuleController {
private final IModuleservice moduleService;
    @PostMapping("/addModuleToClasses")
    public Module addModuleToClasses(@RequestBody Module module, @RequestParam List<String> classIds, @RequestParam String semestre) {
        return moduleService.addModuleToClasses(module, classIds, semestre);
    }
    @GetMapping("getAllModules")
    public List<Module> getAllModules() {
        return moduleService.getAllModules();
    }

    @DeleteMapping("DeleteModule/{id}")
    public void DeleteModule(@PathVariable("id") String id){
        moduleService.removeModule(id);
    }


    @PutMapping("updateModule")
    public Module updateModule(@RequestBody Module module)
    {
        return  moduleService.updateModule(module);
    }


    @GetMapping("/searchModule")
    public List<Module> searchModule(@RequestParam(required = false) String name) {
        return moduleService.searchModules(name);
    }
    @GetMapping("getmodulebyid/{id}")
    public Module getById(@PathVariable("id") String id){
        return moduleService.getById(id);
    }
}
