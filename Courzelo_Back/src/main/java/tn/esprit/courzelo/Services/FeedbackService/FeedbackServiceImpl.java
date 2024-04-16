package tn.esprit.courzelo.Services.FeedbackService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.courzelo.Repositories.FeedbackRepo.FeedbackRepo;
import tn.esprit.courzelo.entities.FeedBackEntities.Feedback;
import tn.esprit.courzelo.entities.FeedBackEntities.TypeFeedback;

import java.util.List;

@Service
@Slf4j

public class FeedbackServiceImpl implements IFeedbackService{
    @Autowired
    FeedbackRepo feedbackRepo;
    @Override
    public List<Feedback> getAllFeedbacks() {
        try{
            return feedbackRepo.findAll();
        } catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Feedback getFeedbackById(String id) {
        try {
            return feedbackRepo.findById(id).get();
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public void addFeedback(Feedback feedback, TypeFeedback  typeFeedback) {
        try{
            feedback.setTypeFeedback(typeFeedback);
            feedback.setTypeFeedback(TypeFeedback.Module);
            feedbackRepo.save(feedback);

        } catch (Exception e){
            log.error(e.getMessage());

        }
    }

    @Override
    public void addFeedbackTeacher(Feedback feedback) {
        try{
            feedback.setTypeFeedback(TypeFeedback.Teacher);
            feedbackRepo.save(feedback);

        } catch (Exception e){
            log.error(e.getMessage());

        }
    }

    @Override
    public void deleteFeedback(String id) {
        try{
            feedbackRepo.deleteById(id);

        } catch (Exception e){
            log.error(e.getMessage());

        }
    }

    @Override
    public void updateFeedback(String id, Feedback feedback) {
        try {
            feedbackRepo.findById(id).ifPresent(feedback1 -> {
                feedback1.setDescription(feedback.getDescription());
                feedback1.setTypeFeedback(feedback.getTypeFeedback());
                feedback1.setQuestionFeedbacks(feedback.getQuestionFeedbacks());
                feedback1.setTeacher( feedback.getTeacher());
                feedback1.setStudent(feedback.getStudent());
                feedback1.setModule(feedback.getModule());
                feedbackRepo.save(feedback1);
            });


        } catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
