package tn.esprit.courzelo.Services.EvaluationService;

import tn.esprit.courzelo.entities.EvaluationEntities.QAnswer;

import java.util.List;

public interface IQAnswerService {
    List<QAnswer> retrieveAllQAnswers();

    QAnswer  addQAnswer(QAnswer  QAnswer);

    QAnswer updateQAnswer(QAnswer QAnswer);

    QAnswer retrieveQAnswer(String idQAnswer);

    void removeQAnswer (String idQAnswer);


}
