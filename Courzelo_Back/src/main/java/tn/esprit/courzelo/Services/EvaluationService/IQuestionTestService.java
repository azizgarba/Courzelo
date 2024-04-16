package tn.esprit.courzelo.Services.EvaluationService;

import tn.esprit.courzelo.entities.EvaluationEntities.QAnswer;
import tn.esprit.courzelo.entities.EvaluationEntities.QuestionTest;

import java.util.List;
import java.util.Set;

public interface IQuestionTestService {
    List<QuestionTest> retrieveAllQuestionTests();

    QuestionTest  addQuestionTest(QuestionTest  QuestionTest);

    QuestionTest updateQuestionTest(QuestionTest QuestionTest);

    QuestionTest retrieveQuestionTest(String idQuestionTest);
    void removeQuestionTest (String idQuestionTest);

    QuestionTest AssignQuestionToAnswer(String idQuestionTest ,  List<QAnswer> answers);

}
