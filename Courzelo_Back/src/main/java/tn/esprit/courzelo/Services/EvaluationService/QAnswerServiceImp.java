package tn.esprit.courzelo.Services.EvaluationService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.courzelo.Repositories.EvaluationRepo.QAnswerRepo;
import tn.esprit.courzelo.Repositories.EvaluationRepo.QuestionTestRepo;
import tn.esprit.courzelo.entities.EvaluationEntities.QAnswer;
import tn.esprit.courzelo.entities.EvaluationEntities.QuestionTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class QAnswerServiceImp implements IQAnswerService{
    private QuestionTestRepo questionTestRepo;
    private QAnswerRepo qAnswerRepo;
    @Override
    public List<QAnswer> retrieveAllQAnswers() {
        return qAnswerRepo.findAll();
    }

    @Override
    public QAnswer addQAnswer(QAnswer qAnswer) {
        return qAnswerRepo.save(qAnswer);
    }

    @Override
    public QAnswer updateQAnswer(QAnswer qAnswer) {
        return qAnswerRepo.save(qAnswer);
    }

    @Override
    public QAnswer retrieveQAnswer(String idQAnswer) {
        return qAnswerRepo.findById(idQAnswer).orElseThrow();
    }

    @Override
    public void removeQAnswer(String idQAnswer) {
        qAnswerRepo.deleteById(idQAnswer);
    }



    }
