package tn.esprit.courzelo.Controllers.EvaluationController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.courzelo.Services.EvaluationService.IEvaluationService;
import tn.esprit.courzelo.Services.EvaluationService.ITestService;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Module;
import tn.esprit.courzelo.entities.EvaluationEntities.Evaluation;
import tn.esprit.courzelo.entities.EvaluationEntities.Test;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@Tag(name = "Evaluation")
@RequestMapping("/evaluations")
public class EvaluationController {
    private IEvaluationService iEvaluationService;
    private ITestService iTestService;
    @Operation(description = "Add Evaluation")
    @PostMapping("/add/{moduleId}/{studentId}")
    public Evaluation addEvaluation(@PathVariable String moduleId , @PathVariable String studentId ,@RequestBody Evaluation evaluation){
        return  iEvaluationService.addEvaluation(moduleId , studentId ,evaluation);
    }

    @Operation(description = "Retrieve all Evaluations")
    @GetMapping("/all")
    public List<Evaluation> getAllEvaluations(){
        return iEvaluationService.retrieveAllEvaluations();
    }

    @Operation(description = "Update Evaluation ")
    @PutMapping("/update")
    public Evaluation updateEvaluation(@RequestBody Evaluation evaluation){
        return  iEvaluationService.updateEvaluation(evaluation);
    }

    @Operation(description = "Retrieve Evaluation by Id")
    @GetMapping("/get/{idEvaluation}")
    public Evaluation getById(@PathVariable("idEvaluation") String idEvaluation){
        return iEvaluationService.retrieveEvaluation(idEvaluation);
    }

    @Operation(description = "Remove Evaluation by Id")
    @DeleteMapping("/remove/{idEvaluation}")
    public ResponseEntity<String> removeEvaluation(@PathVariable("idEvaluation") String idEvaluation) {
        try {
            iEvaluationService.removeEvaluation(idEvaluation);
            return ResponseEntity.ok("Evaluation removed successfully");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Evaluation not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while removing the evaluation");
        }
    }


    @Operation(description = "take Test and calculate mark ")
    @PostMapping("/{idTest}/{idStudent}/takeTest")
  public Evaluation takeTest(@PathVariable ("idTest")String testId, @PathVariable ("idStudent")String studentId, @RequestBody Map<String, String> studentAnswers) {
        Evaluation evaluation = iEvaluationService.takeTest(testId ,studentId, studentAnswers);
        return evaluation ;

    }

    @GetMapping("/findModule/{testId}/{studentId}")
    public Evaluation findModule(@PathVariable String testId,@PathVariable String studentId) {
        Evaluation evaluation = iEvaluationService.findmodule(testId,studentId);
        return evaluation;
    }

    @PostMapping("/assignTestToModule")
    public ResponseEntity<Module> assignTestToModule(
            @RequestParam("moduleId") String moduleId,
            @RequestParam("testId") String testId) {
        try {
            Module updatedModule = iEvaluationService.assignTestToModule(moduleId, testId);
            return new ResponseEntity<>(updatedModule, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/assignStudentAndModuleToEvaluation")
    public ResponseEntity<Evaluation> assignStudentToEvaluation(
            @RequestParam("evaluationId") String evaluationId,
            @RequestParam("studentId") String studentId,@RequestParam("moduleId") String moduleId
            ) {
        try {
            Evaluation updateEvaluation = iEvaluationService.assignStudentAndModuleToEvaluation(evaluationId, studentId , moduleId);
            return new ResponseEntity<>(updateEvaluation, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/module-evaluation")
    public ResponseEntity<Evaluation> moduleEvaluation(
            @RequestParam ("moduleId") String moduleId,
            @RequestParam ("studentId") String studentId) {
        try {
            Evaluation result = iEvaluationService.ModuleEvaluation( moduleId, studentId);
            return ResponseEntity.ok(result);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(description = "Retrieve all Evaluations")
    @GetMapping("/allModules")
    public List<Module> getAllModules(){
        return iEvaluationService.retrieveAllModule();
    }



    @GetMapping("/statistics/{studentId}")
    public ResponseEntity<UserCourzelo> getStudentPerformanceStatistics(@PathVariable String studentId) {
        try {
            UserCourzelo statistics = iEvaluationService.getStudentPerformanceStatistics(studentId);

            return ResponseEntity.ok(statistics);
        } catch (Exception e) {
            return ResponseEntity.status(404).build();
        }
    }

    @Operation(description = "Retrieve all Evaluations of student")
    @GetMapping("/allbystudent/{studentId}")
    public List<Evaluation> getAllEvaluationsBystudent(@PathVariable String studentId){
        return iEvaluationService.retrieveEvaluationByUser(studentId);
    }
    @Operation(description = "get student")
    @GetMapping("/getStudent/{studentId}")
    public UserCourzelo getStudent(@PathVariable String studentId){
        return iEvaluationService.findStudent(studentId);
    }
    @Operation(description = "get nb silver badge")
    @GetMapping("/SilverBadges/{studentId}")
    public Integer getStudentSilverBadges(@PathVariable String studentId ){
        return iEvaluationService.silverBadges(studentId);
    }
    @Operation(description = "get nb bronze badge")
    @GetMapping("/bronzeBadges/{studentId}")
    public Integer getStudentbronzeBadges(@PathVariable String studentId ){
        return iEvaluationService.bronzeBadges(studentId);
    }
    @Operation(description = "get nb gold badge")
    @GetMapping("/goldBadges/{studentId}")
    public Integer getStudentgoldBadges(@PathVariable String studentId ){
        return iEvaluationService.goldBadges(studentId);
    }
    @Operation(description = "get nb dimond badge")
    @GetMapping("/dimondBadges/{studentId}")
    public Integer getStudentdimondBadges(@PathVariable String studentId ){
        return iEvaluationService.dimondBadges(studentId);
    }

    @Operation(description = "calculate final grade")
    @PostMapping("/final/{idStudent}")
    public Evaluation finalGrade(@PathVariable ("idStudent")String studentId) {
        Evaluation evaluation = iEvaluationService.finalEvaluation(studentId );
        return evaluation ;

    }
    @Operation(description = "calculate finals grades")
    @GetMapping("/finals")
    public List<Evaluation> finalsGrade() {
        List <Evaluation> evaluations = iEvaluationService.finalsEvaluations();
        return evaluations ;

    }

    @Operation(description = "get my final grade")
    @GetMapping("/getmyfinal/{idStudent}")
    public Evaluation finalsGrade(@PathVariable ("idStudent")String studentId) {
        Evaluation evaluation = iEvaluationService.getFinalEvaluation(studentId);
        return evaluation ;

    }
    @Operation(description = "get student strengths")
    @GetMapping("/strengths/{idStudent}")
    public List<String> strengths(@PathVariable ("idStudent")String studentId) {
        List<String> strengths= iEvaluationService.analysePerformanceStrengths(studentId);
        return strengths ;

    }
    @Operation(description = "weaknesses")
    @GetMapping("/weaknesses/{idStudent}")
    public List<String> weaknesses(@PathVariable ("idStudent")String studentId) {
        List<String> weaknesses= iEvaluationService.analysePerformanceweakneses(studentId);
        return weaknesses ;

    }

    @Operation(description = "getmodue of weakness")
    @GetMapping("/weaknessesModule/{idStudent}")
    public List<Module>  weaknessesmodule(@PathVariable ("idStudent")String studentId) {
        List<Module>  modules= iEvaluationService.analyseweakneses(studentId);
        return modules ;

    }
}


