package tn.esprit.courzelo.Controllers.ForumController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.courzelo.Services.ForumService.AnswerServiceImpl;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Module;
import tn.esprit.courzelo.entities.ForumEntities.Answer;

import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name = "ForumAnswer")
@RequestMapping("/answers")
public class AnswerController {
    AnswerServiceImpl answerService ;
    @PostMapping("/create/{userId}/{questionId}")
    public Answer createAnswer(@RequestBody Answer answer, @PathVariable String userId,@PathVariable String questionId) {
        return  answerService.createAnswer(answer,userId, questionId);

    }

    @PutMapping("/update")
    public Answer updateAnswer(@RequestBody Answer answer) {
        return  answerService.updateAnswer(answer);

    }

    @GetMapping("/all")
    public List<Answer> getAllAnswers() {
        return answerService.getAllAnswers();

    }

    @GetMapping("/{id}")
    public Answer getAnswerById(@PathVariable String id) {
        return answerService.getAnswerById(id);

    }
    @GetMapping("/nombreVote/{id}")
    public int getAnswerNbVote(@PathVariable String id) {
        return answerService.getNombreVoteAnswer(id);

    }

    @DeleteMapping("/{id}")
    public Void  deleteAnswer(@PathVariable String id) {
        answerService.deleteAnswer(id);

        return null;
    }
    @GetMapping("/getAnswersByQuestion/{idQuestion}")
    public List<Answer>  getQuestionById(@PathVariable String idQuestion) {
        return answerService.getAllAnswersByQuestion(idQuestion);
    }
    @GetMapping("/getALLModule/all")
    public List<Module> getAllModule() {
        return answerService.getAllModule();
    }
    @GetMapping("/getModuleByName/{name}")
    public Module getAllModule(@PathVariable String name) {
        return answerService.findIdModuleByName(name);
    }

    @GetMapping("/getOderByVote/{idQuestion}")
    public List<Answer> getAllAnswersOrderBuVote(@PathVariable String idQuestion) {
        return answerService.getAnswersOrderByNbVote(idQuestion);
    }
}
