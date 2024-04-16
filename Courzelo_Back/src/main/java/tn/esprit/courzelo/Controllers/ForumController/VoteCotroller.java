package tn.esprit.courzelo.Controllers.ForumController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import tn.esprit.courzelo.Services.ForumService.VoteServiceImpl;
import tn.esprit.courzelo.entities.ForumEntities.BadgeForumTeacher;
import tn.esprit.courzelo.entities.ForumEntities.Incentives;
import tn.esprit.courzelo.entities.ForumEntities.QuestionForum;
import tn.esprit.courzelo.entities.ForumEntities.Votes;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name = "ForumVote")
@RequestMapping("/ForumVote")

public class VoteCotroller {
    VoteServiceImpl voteService ;
    private SimpMessagingTemplate messagingTemplate;

    @SendTo("/topic/primes")// Le sujet auquel envoyer la réponse

    @PostMapping("/create/{userId}/{answerId}")
    public Votes createVote(@RequestBody  Votes v, @PathVariable String userId, @PathVariable String answerId) {

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

    @GetMapping("/getIncentiveesByTeacher/{idUser}")
    public List<Incentives> getIncetiveByTehaer(@PathVariable String idUser) {
        return voteService.IncetivesByTeacher(idUser);

    }
    @SendTo("/topic/prime2")// Le sujet auquel envoyer la réponse
    @PostMapping("/createPrimChat/{userId}")
    public Incentives createPrimChat( @PathVariable String userId) {
        String notificationMessage = " New Prime d'explication added to you " ;

        // Envoyer le message aux abonnés du sujet WebSocket
        messagingTemplate.convertAndSend("/topic/prime2", notificationMessage);
        return  voteService.approuvedChat(userId);


    }
    @GetMapping("/getBadgeByTeacher/{idUser}")
    public List<BadgeForumTeacher> getBadgesByTehaer(@PathVariable String idUser) {
        return voteService.getBagesByUser(idUser);

    }
    @GetMapping("/getUser/{idUser}")
    public UserCourzelo getUser(@PathVariable String idUser) {
        return voteService.getUserById(idUser);

    }
    @GetMapping("/insentiveVoteRange")
    public long  getAllVoteInsetive() {
        return voteService.rangeVoteIncentive();

    }
    @GetMapping("/insentiveExplanRange")
    public long  getAllExplanInsetive() {
        return voteService.rangeExplanIncentive();

    }
    @GetMapping("/badgeRange")
    public long  getbadgeRage() {
        return voteService.rangeBadge();

    }
}
