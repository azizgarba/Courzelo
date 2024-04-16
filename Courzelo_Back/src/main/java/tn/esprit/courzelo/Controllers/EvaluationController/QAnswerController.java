package tn.esprit.courzelo.Controllers.EvaluationController;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.courzelo.Services.EvaluationService.IQAnswerService;
import tn.esprit.courzelo.Services.EvaluationService.QAnswerServiceImp;
import tn.esprit.courzelo.entities.EvaluationEntities.Evaluation;
import tn.esprit.courzelo.entities.EvaluationEntities.QAnswer;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@Tag(name = "QAnswer")
@RequestMapping("/QAnswers")
public class QAnswerController {

    private IQAnswerService iqAnswerService;
    @Operation(description = "Add QAnswer")
    @PostMapping("/add")
    public QAnswer addQAnswer(@RequestBody QAnswer qAnswer){
        return  iqAnswerService.addQAnswer(qAnswer);
    }

    @Operation(description = "Retrieve all QAnswers")
    @GetMapping("/all")
    public List<QAnswer> getAllQAnswers(){
        return iqAnswerService.retrieveAllQAnswers();
    }

    @Operation(description = "Update QAnswer ")
    @PutMapping("/update")
    public QAnswer updateQAnswer(@RequestBody QAnswer qAnswer){
        return  iqAnswerService.updateQAnswer(qAnswer);
    }

    @Operation(description = "Retrieve all QAnswers by Id")
    @GetMapping("/get/{idQAnswer}")
    public QAnswer getById(@PathVariable("idQAnswer") String idQAnswer){
        return iqAnswerService.retrieveQAnswer(idQAnswer);
    }

    @Operation(description = "Remove QAnswer by Id")
    @DeleteMapping("/remove/{idQAnswer}")
    public ResponseEntity<String> removeQAnswer(@PathVariable("idQAnswer") String idQAnswer) {
        try {
            iqAnswerService.removeQAnswer(idQAnswer);
            return ResponseEntity.ok("QAnswer removed successfully");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("QAnswer not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while removing the QAnswer");
        }
    }




    }







