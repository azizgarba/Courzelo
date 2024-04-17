package tn.esprit.courzelo.Services.AcedemicModuleService.Level;

import tn.esprit.courzelo.entities.AcademicProgramEntities.Level;

import java.util.List;
import java.util.Optional;

public interface ILevelService {

    List<Level> GetLevels();
    Level addLevel(Level level);
    void removeLevel (String id );
   Level updateLevel(Level level);
   Level getById(String id);
}
