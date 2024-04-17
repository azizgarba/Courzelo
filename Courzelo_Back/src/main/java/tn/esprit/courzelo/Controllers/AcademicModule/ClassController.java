package tn.esprit.courzelo.Controllers.AcademicModule;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.courzelo.Services.AcedemicModuleService.Class.IClassService;

import tn.esprit.courzelo.entities.AcademicProgramEntities.Class;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Level;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Module;


import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name = "Class")
public class ClassController {

    private final IClassService ClassService ;

    @GetMapping("/listofclass")
    public List<Class> getAllClasses(){
        return ClassService.GetClasses();
    }

    @PostMapping("/addclass")
    public Class addClassAndAssignToLevel(@RequestBody Class aClass, @RequestParam("id") String id) {
        System.out.println("Received request with data: " + aClass.toString());
        return ClassService.addClassAndAssignToLevel(aClass, id);
    }

    @DeleteMapping("DeleteClass/{id}")
    public void deleteClass(@PathVariable("id") String id){
        ClassService.removeClass(id);
    }


    @PutMapping("/updateClasses")
    public Class updateClasses(@RequestBody Class aClass){
        return  ClassService.updateClass(aClass);
    }

    @GetMapping("getclassbyid/{id}")
    public Class getById(@PathVariable("id") String id){
        return ClassService.getById(id);
    }



}
