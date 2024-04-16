package tn.esprit.courzelo.Services.EvaluationService;

import tn.esprit.courzelo.entities.EvaluationEntities.QAnswer;
import tn.esprit.courzelo.entities.EvaluationEntities.QuestionTest;
import tn.esprit.courzelo.entities.EvaluationEntities.Test;

import java.util.List;
import java.util.Map;

public interface ITestService {
    List<Test> retrieveAllTests();

    Test  addTest(String moduleId ,String teacherId , Test  Test );

    Test updateTest(Test Test);

    Test retrieveTest(String idTest);

    void removeTest (String idTest);

   Test AssignTestToQuestion(String idTest , List<QuestionTest>   questionTests) ;
    List<Test> retrieveTestsSortedByAttributeAndValue(String attributeName, Object attributeValue) ;
}
