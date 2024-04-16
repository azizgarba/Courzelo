package tn.esprit.courzelo.Services.FeedbackService;

import tn.esprit.courzelo.entities.FeedBackEntities.QuestionFeedback;
import tn.esprit.courzelo.entities.FeedBackEntities.TypeFeedback;
import tn.esprit.courzelo.entities.FeedBackEntities.TypeOption;

import java.util.List;

public interface IQuestionFeedbackService {
    // get all question feedbacks
    public List<QuestionFeedback> getAllQuestionFeedbacks();
    // get question feedback by id
    public QuestionFeedback getQuestionFeedbackById(String id);
    // add question feedback
    public void addQuestionFeedback(QuestionFeedback questionFeedback);
    // delete question feedback
    public void deleteQuestionFeedback(String id);
    // update question feedback
    public void updateQuestionFeedback(String id, QuestionFeedback questionFeedback);
}
