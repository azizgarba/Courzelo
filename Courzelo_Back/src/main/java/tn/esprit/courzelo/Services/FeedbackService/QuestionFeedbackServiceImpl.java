package tn.esprit.courzelo.Services.FeedbackService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.courzelo.Repositories.FeedbackRepo.QuestionFeedbackRepo;
import tn.esprit.courzelo.entities.FeedBackEntities.QuestionFeedback;
import tn.esprit.courzelo.entities.FeedBackEntities.TypeFeedback;
import tn.esprit.courzelo.entities.FeedBackEntities.TypeOption;

import java.util.List;

@Service
@Slf4j

public class QuestionFeedbackServiceImpl implements IQuestionFeedbackService{
    @Autowired
    QuestionFeedbackRepo questionFeedbackRepo;
    @Override
    public List<QuestionFeedback> getAllQuestionFeedbacks() {
        try{
            return questionFeedbackRepo.findAll();
        } catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public QuestionFeedback getQuestionFeedbackById(String id) {
        try {
            return questionFeedbackRepo.findById(id).get();
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public void addQuestionFeedback(QuestionFeedback questionFeedback, TypeOption typeOption) {
        try{
            questionFeedback.setTypeOption(typeOption);
            questionFeedbackRepo.save(questionFeedback);
        } catch (Exception e){
            log.error(e.getMessage());
        }
    }

    @Override
    public void deleteQuestionFeedback(String id) {
        try{
            questionFeedbackRepo.deleteById(id);

        } catch (Exception e){
            log.error(e.getMessage());
        }
    }

    @Override
    public void updateQuestionFeedback(String id,QuestionFeedback questionFeedback){
        try{
            questionFeedbackRepo.findById(id).ifPresent(questionFeedback1 -> {
                questionFeedback1.setDescription(questionFeedback.getDescription());
                questionFeedback1.setTypeOption(questionFeedback.getTypeOption());
                questionFeedback1.setAdmin(questionFeedback.getAdmin());
                questionFeedbackRepo.save(questionFeedback1);
            });

        } catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
