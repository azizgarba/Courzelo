package tn.esprit.courzelo.Controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.courzelo.Services.ForumService.QuestionForumImpl;
import tn.esprit.courzelo.entities.QuestionForum;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Tag(name = "ForumQuestion")
public class QuestionForumController {

    private final QuestionForumImpl questionForumService;



    @PostMapping
    public ResponseEntity<QuestionForum> createQuestion(@RequestBody QuestionForum questionForum) {
        QuestionForum createdQuestion = questionForumService.createQuestion(questionForum);
        return new ResponseEntity<>(createdQuestion, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<QuestionForum>> getAllQuestions() {
        List<QuestionForum> questions = questionForumService.getAllQuestions();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionForum> getQuestionById(@PathVariable Long id) {
        Optional<QuestionForum> question = questionForumService.getQuestionById(id);
        return question.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionForum> updateQuestion(@PathVariable Long id, @RequestBody QuestionForum questionForum) {
        questionForum.setId(id);
        QuestionForum updatedQuestion = questionForumService.updateQuestion(questionForum);
        return new ResponseEntity<>(updatedQuestion, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestionById(@PathVariable Long id) {
        questionForumService.deleteQuestionById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}