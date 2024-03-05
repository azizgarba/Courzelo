package tn.esprit.courzelo.Controllers.ForumController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;
import tn.esprit.courzelo.Services.ForumService.QuestionForumImpl;
import tn.esprit.courzelo.Services.ForumService.RateQuestionServiceImpl;
import tn.esprit.courzelo.entities.ForumEntities.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Tag(name = "ForumQuestion")
@RequestMapping("/questions")
public class QuestionForumController {
    QuestionForumImpl questionForumImpll ;
    RateQuestionServiceImpl rateQuestionServiceImpl;


    @PostMapping("/create/{userId}/{moduleId}")
    public QuestionForum createQuestion(@RequestBody QuestionForum q, @PathVariable String userId, @PathVariable String moduleId) throws InterruptedException {
        Thread.sleep(1000);
        return   questionForumImpll.AddQuestion(q,userId,moduleId);


    }
    @PutMapping("/update")
    public QuestionForum updateQuestion(@RequestBody QuestionForum q) {
        return  questionForumImpll.updateQuestion(q);

    }

    @GetMapping("/all")
    public List<QuestionForum> getAllQuestion() {
        return questionForumImpll.getAllQuestions();

    }

    @GetMapping("/{id}")
    public QuestionForum getQuestionById(@PathVariable String id) {
        return questionForumImpll.getQuestionById(id);

    }

    @DeleteMapping("/{id}")
    public Void deleteQuestionById(@PathVariable String id) {
        questionForumImpll.deleteQuestionById(id);

        return null;
    }

    @PostMapping("/Rating/create/{questionId}/{userId}")
    public RateQuestion rateQuestion(@RequestBody RateQuestion rate, @PathVariable String questionId, @PathVariable String userId) {

            return rateQuestionServiceImpl.rateQuestion(rate, questionId, userId);

    }
    @GetMapping("/Rate/{id}")
    public RateQuestion getRateQuestionById(String id) {
        return rateQuestionServiceImpl.getRateQuestionById(id);
    }
    @PutMapping("/Rate/update")
    public RateQuestion updateRateQuestion(@RequestBody RateQuestion rate) {
        return rateQuestionServiceImpl.updateRateQuestion(rate);
    }
    @GetMapping("/Rate/{idQ}/{idU}")
    public RateQuestion getRateQuestionByQuestionAndUser(@PathVariable String idQ, @PathVariable String idU) {
        return rateQuestionServiceImpl.getRateQuestionByQuestionAndUser(idQ, idU);
    }
    @PutMapping("/updateRateQustion/update")
    public QuestionForum updateQuestionRate(@RequestBody QuestionForum q) {
        return questionForumImpll.updateQuestionRate(q);
    }

    @GetMapping("/getTotalRateAverage/{idQ}/")
    public float getTotalRte(@PathVariable String idQ) {
        return rateQuestionServiceImpl.avargeRateForQuestion(idQ);
    }


    @GetMapping("/orderByModule/{idm}")
    public List<QuestionForum> getQuestionOrderByModule(@PathVariable String idm) {
        return questionForumImpll.getQuestionByModule(idm);
    }
    @GetMapping("/orderByRatingAverge")
    public List<QuestionForum> getQuestionOrderByRatingAverge() {
        return rateQuestionServiceImpl.getQuestionOrderByRate();
    }
    @GetMapping("/searchBytitle/{title}")
    public List<QuestionForum> getQuestionbytitle( @PathVariable String title) {
        return questionForumImpll.getQuestionByTitle(title);
    }


}