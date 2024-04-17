package tn.esprit.courzelo.Controllers.AcademicModule;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tn.esprit.courzelo.Services.AcedemicModuleService.Course.ICoursesService;

import tn.esprit.courzelo.entities.AcademicProgramEntities.Course;

import tn.esprit.courzelo.entities.AcademicProgramEntities.ResponseData;

import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name = "Course")
public class CourseController {
    private final ICoursesService CoursesService ;

    @GetMapping("/listofcourses")
    public List<Course> getAllCourses(){
        return CoursesService.GetCourses();
    }

    @PostMapping(value="/addcourse")

    public Course addCourse(@RequestBody Course course,
                            @RequestParam("moduleId") String moduleId) {

            return CoursesService.addCoursesAndAssignToModule(course, moduleId);

    }
    @DeleteMapping("DeleteCourse/{id}")
    public void deleteCourse(@PathVariable("id") String id){
        CoursesService.removeCourse(id);
    }

    @PutMapping("/updateCourses")
    public Course updateCourse(@RequestBody Course course){
        return  CoursesService.updateCourse(course);
    }

    @GetMapping("getcoursebyid/{id}")
    public Course getById(@PathVariable("id") String id){
        return CoursesService.getById(id);
    }

    @GetMapping("/getcoursebymodule/{moduleId}")
    public List<Course> getCoursesByModuleId(@PathVariable String moduleId) {
        return CoursesService.getCoursesByModuleId(moduleId);
    }



}

