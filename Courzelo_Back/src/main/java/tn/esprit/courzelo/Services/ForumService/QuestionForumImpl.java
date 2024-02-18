package tn.esprit.courzelo.Services;


import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import tn.esprit.courzelo.Repositories.QuestionForumRepo;
import tn.esprit.courzelo.entities.QuestionForum;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuestionForumImpl  {
    private final QuestionForumRepo questionForumRepository;
    // Create or Update
    public QuestionForum createQuestion(QuestionForum questionForum) {
        return questionForumRepository.save(questionForum);
    }

    // Read
    public List<QuestionForum> getAllQuestions() {
        return questionForumRepository.findAll();
    }

    public Optional<QuestionForum> getQuestionById(Long id) {
        return questionForumRepository.findById(id);
    }

    // Update
    public QuestionForum updateQuestion(QuestionForum updatedQuestion) {
        return questionForumRepository.save(updatedQuestion);
    }

    // Delete
    public void deleteQuestionById(Long id) {
        questionForumRepository.deleteById(id);
    }

}
