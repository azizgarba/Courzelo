package tn.esprit.courzelo.Services.AcedemicModuleService.Course;

import org.springframework.web.multipart.MultipartFile;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Course;

import java.util.List;

public interface ICoursesService {
    List<Course> GetCourses();
    Course addCoursesAndAssignToModule(Course course, String id);
    void removeCourse(String id);
    Course updateCourse(Course course);
    Course getById(String id);
    List<Course> getCoursesByModuleId(String moduleId);

}
