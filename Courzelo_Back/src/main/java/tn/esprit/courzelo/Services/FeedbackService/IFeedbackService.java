package tn.esprit.courzelo.Services.FeedbackService;

import tn.esprit.courzelo.entities.FeedBackEntities.Feedback;
import tn.esprit.courzelo.entities.FeedBackEntities.TypeFeedback;

import java.util.List;

public interface IFeedbackService {
    // get all  feedbacks
    public List<Feedback> getAllFeedbacks();
    // get feedback by id
    public Feedback getFeedbackById(String id);
    // add feedbackmodule
    public void addFeedback(Feedback feedback, TypeFeedback typeFeedback);
    // add feedbackTeacher
    public void addFeedbackTeacher(Feedback feedback);
    // delete feedback
    public void deleteFeedback(String id);
    // update feedback
    public void updateFeedback(String id, Feedback feedback);
}
