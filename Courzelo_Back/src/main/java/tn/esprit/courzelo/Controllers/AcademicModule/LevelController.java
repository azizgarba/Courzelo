package tn.esprit.courzelo.Controllers.AcademicModule;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.courzelo.Services.AcedemicModuleService.Level.ILevelService;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Level;

import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name = "Level")
public class LevelController {

    private final ILevelService LevelService ;
    @GetMapping("/listoflevel")
    public List<Level> getAllLevel(){
        return LevelService.GetLevels();
    }

    @PostMapping("/addlevel")
            public Level addLevel(@RequestBody Level level){
            return  LevelService.addLevel(level);
            }

    @PutMapping("/Updatelevel")
    public Level Updatelevel (@RequestBody  Level level){
        return LevelService.updateLevel(level);
    }

    @DeleteMapping("Deletelevel/{id}")
    public void deleteLevel(@PathVariable("id") String id){
        LevelService.removeLevel(id);
    }


    @GetMapping("getlevelbyid/{id}")
    public Level getById(@PathVariable("id") String id){
        return LevelService.getById(id);
    }

}
