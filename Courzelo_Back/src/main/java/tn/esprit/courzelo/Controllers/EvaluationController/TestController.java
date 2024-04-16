package tn.esprit.courzelo.Controllers.EvaluationController;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.courzelo.Services.EvaluationService.ITestService;
import tn.esprit.courzelo.entities.EvaluationEntities.Evaluation;
import tn.esprit.courzelo.entities.EvaluationEntities.QAnswer;
import tn.esprit.courzelo.entities.EvaluationEntities.QuestionTest;
import tn.esprit.courzelo.entities.EvaluationEntities.Test;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@Tag(name = "Test")
@RequestMapping("/Tests")
public class TestController {
    private ITestService iTestService;
    @Operation(description = "Add Test")
    @PostMapping("/add/{moduleId}/{teacherId}")
    public Test addTest(@PathVariable("moduleId") String moduleId ,@PathVariable("teacherId") String teacherId , @RequestBody Test Test){
        return  iTestService.addTest(moduleId ,teacherId , Test );
    }

    @Operation(description = "Retrieve all Tests")
    @GetMapping("/all")
    public List<Test> getAllTests(){
        return iTestService.retrieveAllTests();
    }

    @Operation(description = "Update Test ")
    @PutMapping("/update")
    public Test updateTest(@RequestBody Test Test){
        return  iTestService.updateTest(Test);
    }

    @Operation(description = "Retrieve Test by Id")
    @GetMapping("/get/{idTest}")
    public Test getById(@PathVariable("idTest") String idTest){
        return iTestService.retrieveTest(idTest);
    }
    @Operation(description = "Remove Test by Id")
    @DeleteMapping("/remove/{idTest}")
    public ResponseEntity<Object> removeTest(@PathVariable("idTest") String idTest) {
        try {
            iTestService.removeTest(idTest);
            return ResponseEntity.ok().build(); // Return an empty JSON object
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Test not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while removing the Test");
        }

    }

    @PostMapping("/addAndAsign/{idTest}")
    public ResponseEntity<Test> AssignTestToQuestion(
            @PathVariable ("idTest")String idTest,
            @RequestBody List<QuestionTest> questionTests ) {

        Test test = iTestService.AssignTestToQuestion(idTest, questionTests);

        return new ResponseEntity<>(test, HttpStatus.CREATED);
    }



    @GetMapping("/sorted")
    public List<Test> retrieveTestsSortedByAttributeAndValue(
            @RequestParam String attributeName,
            @RequestParam Object attributeValue) {
        return iTestService.retrieveTestsSortedByAttributeAndValue(attributeName, attributeValue);
    }

}
