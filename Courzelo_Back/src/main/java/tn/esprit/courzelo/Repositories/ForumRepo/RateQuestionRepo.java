package tn.esprit.courzelo.Repositories.ForumRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.courzelo.entities.ForumEntities.QuestionForum;
import tn.esprit.courzelo.entities.ForumEntities.RateQuestion;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.List;

public interface RateQuestionRepo extends MongoRepository<RateQuestion,String> {
    RateQuestion findRateQuestionById(String id);
    RateQuestion findRateQuestionByQuestionForumAndUser(QuestionForum q, UserCourzelo u);
    List<RateQuestion> findRateQuestionByQuestionForum(QuestionForum q);
}
