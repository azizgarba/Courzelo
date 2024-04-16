package tn.esprit.courzelo.Controllers.FeedbackController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.courzelo.Services.FeedbackService.IFeedbackService;
import tn.esprit.courzelo.entities.FeedBackEntities.Feedback;

import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name = "Feedback")
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    IFeedbackService feedbackService;
    //get all feedbacks
    @GetMapping("/all")
    public ResponseEntity<List<Feedback>> getAllFeedbacks(){
        try{
            List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
            if(feedbacks.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(feedbacks);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    //get feedback by id
    @GetMapping("/id/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable("id") String id){
        try{
            Feedback feedback = feedbackService.getFeedbackById(id);
            if(feedback == null){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(feedback);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    //add feedback
    @PostMapping("/add")
    public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback){
        try{
            feedbackService.addFeedback(feedback, feedback.getTypeFeedback());
            return ResponseEntity.ok(feedback);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    //add feedback teacher
    @PostMapping("/addTeacher")
    public ResponseEntity<Feedback> addFeedbackTeacher(@RequestBody Feedback feedback){
        try{
            feedbackService.addFeedbackTeacher(feedback);
            return ResponseEntity.ok(feedback);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    //delete feedback
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFeedback( @PathVariable("id") String id){
        try{
            feedbackService.deleteFeedback(id);
            return ResponseEntity.ok("Feedback deleted successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    //update feedback
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateFeedback(@PathVariable("id") String id, @RequestBody Feedback feedback){
        try{
            feedbackService.updateFeedback(id, feedback);
            return ResponseEntity.ok("Feedback updated successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
