package tn.esprit.courzelo.Services.EvaluationService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.courzelo.Repositories.EvaluationRepo.QAnswerRepo;
import tn.esprit.courzelo.Repositories.EvaluationRepo.QuestionTestRepo;
import tn.esprit.courzelo.Repositories.EvaluationRepo.TestRepo;
import tn.esprit.courzelo.Repositories.ModuleRepo.ModuleRepo;
import tn.esprit.courzelo.Repositories.UserRepo.UserRepo;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Module;
import tn.esprit.courzelo.entities.EvaluationEntities.QAnswer;
import tn.esprit.courzelo.entities.EvaluationEntities.QuestionTest;
import tn.esprit.courzelo.entities.EvaluationEntities.Test;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TestServiceImp implements ITestService{
    private TestRepo testRepo ;
    private QuestionTestRepo questionTestRepo;
    private ModuleRepo moduleRepo ;
    private QAnswerRepo qAnswerRepo ;
    private QAnswerServiceImp qAnswerServiceImp ;
    private  QuestionTestServiceImpl questionTestService ;
private UserRepo userRepo;

    @Override
    public List<Test> retrieveAllTests() {
        return testRepo.findAll();
    }

    @Override
    public Test addTest(String moduleId ,String teacherId , Test test) {
        UserCourzelo teacher = userRepo.findById(teacherId).orElseThrow();
        Module module = moduleRepo.findById(moduleId).orElseThrow();
        for (QuestionTest question : test.getQuestions())
        {qAnswerRepo.saveAll(question.getAnswers());}
        questionTestRepo.saveAll(test.getQuestions());
        test.setTeacher(teacher);
        testRepo.save(test);
        if (module.getTests() == null) {
            module.setTests(new ArrayList<>());}
        module.getTests().add(test);
        moduleRepo.save(module);
        return  test;


    }
    @Override
    public Test updateTest(Test test) {
        for  (QuestionTest question : test.getQuestions()) {
            for  (QAnswer qAnswer : question.getAnswers())
            { qAnswerServiceImp.updateQAnswer(qAnswer);}
            questionTestService.updateQuestionTest(question);
        }
        return testRepo.save(test);
    }

    @Override
    public Test retrieveTest(String idTest) {
        return testRepo.findById(idTest).orElseThrow();
    }



    @Override
    public void removeTest(String idTest) {
        Test test = testRepo.findById(idTest).orElseThrow();
        for (QuestionTest question : test.getQuestions()) {
            for  (QAnswer qAnswer : question.getAnswers())
            {  qAnswerServiceImp.removeQAnswer(qAnswer.getId());}
            questionTestService.removeQuestionTest(question.getId());
        }
        testRepo.deleteById(idTest);
    }


    @Override
    public Test AssignTestToQuestion(String idTest, List<QuestionTest> questionTests) {
        Test test =testRepo.findById(idTest).orElseThrow();
        List<QuestionTest> questionTestss = questionTestRepo.saveAll(questionTests);
     //   Set<QuestionTest> existingQuestions = test.getQuestions() != null ? test.getQuestions() : new HashSet<>();
     //   existingQuestions.addAll(questionTests);
     //   test.setQuestions(existingQuestions);
        return testRepo.save(test);

    }

    @Override
    public List<Test> retrieveTestsSortedByAttributeAndValue(String attributeName, Object attributeValue) {
        return retrieveAllTests().stream()
                .filter(test -> {
                    try {
                        Field field = test.getClass().getDeclaredField(attributeName);
                        field.setAccessible(true);
                        Object value = field.get(test);
                        if (value != null) {
                            if (value instanceof String && attributeValue instanceof String) {
                                return ((String) value).toLowerCase().startsWith(((String) attributeValue).toLowerCase());
                            } else if (value instanceof Integer && attributeValue instanceof Integer) {
                                return value.equals(attributeValue);
                            }
                        }
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }
}

