package tn.esprit.courzelo.Services.FeedbackService;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.courzelo.Repositories.FeedbackRepo.FeedbackRepo;

import tn.esprit.courzelo.Repositories.UserRepo.UserRepository;
import tn.esprit.courzelo.entities.FeedBackEntities.Feedback;
import tn.esprit.courzelo.entities.FeedBackEntities.TypeFeedback;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.List;

@Service
@Slf4j


public class FeedbackServiceImpl implements IFeedbackService{
    private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackServiceImpl.class);
@Autowired
    FeedbackRepo feedbackRepo;
@Autowired
UserRepository userRepo;
    //UserCourzelo userCourzeloo;
    @Override
    public List<Feedback> getAllFeedbacks() {
        try{
            return feedbackRepo.findAll();
        } catch (Exception e){
            log.error(e.getMessage()+"laaaaaaaaaaaa");
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
    public Feedback addFeedback(Feedback feedback, String idUser) {
        UserCourzelo userCourzelo = userRepo.findUserCourzeloById(idUser);
        //LOGGER.info("***********************, userCourzelo"+ userCourzelo);
        System.out.println(userCourzelo.getId());
        if(userCourzelo != null){
            feedback.setTypeFeedback(TypeFeedback.Module);
            //LOGGER.info("***********************, userCourzelo"+ userCourzelo);
            feedback.setStudent(userCourzelo);
             return feedbackRepo.save(feedback);
             //LOGGER.info("***********************, userCourzelo"+ userCourzelo);
        }
        //LOGGER.info("***********************, userCourzelo"+ userCourzelo);
        return null;




    }

    @Override
    public void addFeedbackTeacher(Feedback feedback,String idUser) {
        UserCourzelo student = userRepo.findUserCourzeloById(idUser);
        UserCourzelo teacher = userRepo.findUserCourzeloById(idUser);
        try{
            feedback.setTypeFeedback(TypeFeedback.Teacher);
            feedback.setStudent(student);
            feedback.setTeacher(teacher);
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
