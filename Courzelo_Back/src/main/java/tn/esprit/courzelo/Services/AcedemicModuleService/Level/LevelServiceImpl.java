package tn.esprit.courzelo.Services.AcedemicModuleService.Level;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import tn.esprit.courzelo.Repositories.ModuleRepo.LevelRepo;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Level;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class LevelServiceImpl implements ILevelService {

    private final LevelRepo levelRepo;
    @Override
    public List<Level> GetLevels() {
        return levelRepo.findAll();
    }

    @Override
    public Level addLevel(Level level) {
        return levelRepo.save(level);
    }





    @Override
    public Level updateLevel(Level level) {
        return levelRepo.save(level);
    }
    @Override
    public Level getById(String id) {
        return levelRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("no  id " + id));
    }

    @Override
    public void removeLevel(String id) {
        levelRepo.deleteById(id);
    }
}
