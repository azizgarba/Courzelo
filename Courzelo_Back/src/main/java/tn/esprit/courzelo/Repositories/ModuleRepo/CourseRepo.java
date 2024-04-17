package tn.esprit.courzelo.Repositories.ModuleRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Course;

import java.util.List;

public interface CourseRepo extends MongoRepository<Course,String> {

    List<Course> findByModuleId(String moduleId);
}
