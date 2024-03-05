package tn.esprit.courzelo.Repositories.ForumRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.courzelo.entities.ForumEntities.Answer;
import tn.esprit.courzelo.entities.ForumEntities.QuestionForum;
import tn.esprit.courzelo.entities.ForumEntities.Votes;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.List;

public interface VoteRepo  extends MongoRepository<Votes,String> {
    Votes findVotesById(String id);
    Votes findVotesByTeacherAndAnswer(UserCourzelo u, Answer a);
    List<Votes> findVotesByAnswer(Answer a);
    void deleteAll(Iterable<? extends Votes> votes);

}
