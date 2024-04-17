package tn.esprit.courzelo.Services.AcedemicModuleService.Course;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.courzelo.Repositories.ModuleRepo.CourseRepo;
import tn.esprit.courzelo.Repositories.ModuleRepo.ModuleRepo;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Class;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Course;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Level;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Module;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CoursesServiceImpl implements ICoursesService {

    private final CourseRepo courseRepo;
    private final ModuleRepo moduleRepo;
    @Override
    public List<Course> GetCourses() {
        return courseRepo.findAll();
    }

    @Override
    public Course addCoursesAndAssignToModule(Course course, String id) {
        Course savedcourse = courseRepo.save(course);
        Module module = moduleRepo.findById(id).orElseThrow(() ->
                new IllegalArgumentException("No module Found with this id " +id));
        savedcourse.setModule(module);

        courseRepo.save(savedcourse);
        return savedcourse;
    }

    @Override
    public void removeCourse(String id) {
        courseRepo.deleteById(id);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public Course getById(String id) {
        return courseRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("no  id " + id));
    }


    public List<Course> getCoursesByModuleId(String moduleId) {
        return courseRepo.findByModuleId(moduleId);
    }





}

