package tn.esprit.courzelo.Controllers.FeedbackController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.courzelo.Services.FeedbackService.IQuestionFeedbackService;
import tn.esprit.courzelo.entities.FeedBackEntities.QuestionFeedback;

import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name = "QuestionFeedback")
@RequestMapping("/questionFeedback")
public class QuestionFeedbackController {
    @Autowired
    IQuestionFeedbackService questionFeedbackService;

    //get all question feedbacks
    @GetMapping("/all")
    public ResponseEntity<List<QuestionFeedback>> getAllQuestionFeedbacks(){
        try{
            List<QuestionFeedback> questionFeedbacks = questionFeedbackService.getAllQuestionFeedbacks();
            if(questionFeedbacks.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(questionFeedbacks);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    //get question feedback by id
    @GetMapping("/id/{id}")
    public ResponseEntity<QuestionFeedback> getQuestionFeedbackById(@PathVariable("id") String id){
        try{
            QuestionFeedback questionFeedback = questionFeedbackService.getQuestionFeedbackById(id);
            if(questionFeedback == null){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(questionFeedback);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    //add question feedback
    @PostMapping("/add")
    public ResponseEntity<QuestionFeedback> addQuestionFeedback(@RequestBody QuestionFeedback questionFeedback){
        try{
            questionFeedbackService.addQuestionFeedback(questionFeedback, questionFeedback.getTypeOption());
            return ResponseEntity.ok(questionFeedback);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    //delete question feedback
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteQuestionFeedback( @PathVariable("id") String id){
        try{
            questionFeedbackService.deleteQuestionFeedback(id);
            return ResponseEntity.ok("Question feedback deleted successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    //update question feedback
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateQuestionFeedback(@PathVariable("id") String id, @RequestBody QuestionFeedback questionFeedback){
        try{
            questionFeedbackService.updateQuestionFeedback(id, questionFeedback);
            return ResponseEntity.ok("Question feedback updated successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
