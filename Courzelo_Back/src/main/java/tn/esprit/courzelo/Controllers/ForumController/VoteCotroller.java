package tn.esprit.courzelo.Controllers.ForumController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.courzelo.Services.ForumService.VoteServiceImpl;
import tn.esprit.courzelo.entities.ForumEntities.QuestionForum;
import tn.esprit.courzelo.entities.ForumEntities.Votes;

@RestController
@AllArgsConstructor
@Tag(name = "ForumVote")
@RequestMapping("/ForumVote")
public class VoteCotroller {
    VoteServiceImpl voteService ;
    @PostMapping("/create/{userId}/{answerId}")
    public Votes createQuestion(@RequestBody  Votes v, @PathVariable String userId, @PathVariable String answerId) {

        return   voteService.add(v ,userId,answerId);


    }

    @PutMapping("/update")
    public Votes updateVote(@RequestBody  Votes v) {
        return  voteService.update(v);

    }
    @DeleteMapping("/{id}")
    public Void deleteVote(@PathVariable String id) {
        voteService.delete(id);

        return null;
    }
    @GetMapping("/getvoteByUseAndAnswer/{idUser}/{idAnswer}")
    public Votes getVoteByUserAndAnswer(@PathVariable String idUser,@PathVariable String idAnswer) {
        return voteService.getVoteByUserAndAnswer(idUser,idAnswer);

    }
}
