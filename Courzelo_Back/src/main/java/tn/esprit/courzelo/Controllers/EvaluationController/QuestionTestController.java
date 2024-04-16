package tn.esprit.courzelo.Controllers.EvaluationController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.courzelo.Services.EvaluationService.IQuestionTestService;
import tn.esprit.courzelo.entities.EvaluationEntities.Evaluation;
import tn.esprit.courzelo.entities.EvaluationEntities.QAnswer;
import tn.esprit.courzelo.entities.EvaluationEntities.QuestionTest;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@RestController
@AllArgsConstructor
@Tag(name = "QuestionTest")
@RequestMapping("/QuestionTests")
public class QuestionTestController {
    private IQuestionTestService iQuestionTestService;

    @Operation(description = "Add QuestionTest")
    @PostMapping("/add")
    public QuestionTest addQuestionTest(@RequestBody QuestionTest questionTest){
        return  iQuestionTestService.addQuestionTest(questionTest);
    }

    @Operation(description = "Retrieve all QuestionTests")
    @GetMapping("/all")
    public List<QuestionTest> getAllQuestionTests(){
        return iQuestionTestService.retrieveAllQuestionTests();
    }

    @Operation(description = "Update QuestionTest ")
    @PutMapping("/update")
    public QuestionTest updateQuestionTest(@RequestBody QuestionTest questionTest){
        return  iQuestionTestService.updateQuestionTest(questionTest);
    }

    @Operation(description = "Retrieve QuestionTest by Id")
    @GetMapping("/get/{idQuestionTest}")
    public QuestionTest getById(@PathVariable("idQuestionTest") String idquestionTest){
        return iQuestionTestService.retrieveQuestionTest(idquestionTest);
    }

    @Operation(description = "Remove QuestionTest by Id")
    @DeleteMapping("/remove/{idQuestionTest}")
    public ResponseEntity<String> removeQuestionTest(@PathVariable("idQuestionTest") String idquestionTest) {
        try {
            iQuestionTestService.removeQuestionTest(idquestionTest);
            return ResponseEntity.ok("QuestionTest removed successfully");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("QuestionTest not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while removing the QuestionTest");
        }
    }

    @PostMapping("/addAndAsign/{idQuestionTest}")
    public ResponseEntity<QuestionTest> AndAssignQuestionToAnswers(
            @PathVariable ("idQuestionTest")String idquestionTest,
            @RequestBody List<QAnswer> answers) {

        QuestionTest questionTest1 = iQuestionTestService.AssignQuestionToAnswer(idquestionTest, answers);

        return new ResponseEntity<>(questionTest1, HttpStatus.CREATED);
    }


}
