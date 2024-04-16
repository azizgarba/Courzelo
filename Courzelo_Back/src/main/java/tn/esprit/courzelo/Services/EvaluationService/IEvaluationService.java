package tn.esprit.courzelo.Services.EvaluationService;

import tn.esprit.courzelo.entities.AcademicProgramEntities.Module;
import tn.esprit.courzelo.entities.EvaluationEntities.Evaluation;
import tn.esprit.courzelo.entities.EvaluationEntities.Test;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.List;
import java.util.Map;

public interface IEvaluationService {
    List<Evaluation> retrieveAllEvaluations();

    Evaluation  addEvaluation(String moduleId , String studentId , Evaluation  Evaluation);

    Evaluation updateEvaluation(Evaluation Evaluation);

    Evaluation retrieveEvaluation(String idEvaluation);
    void removeEvaluation (String idEvaluation);

    Evaluation takeTest(String testId , String studentId, Map<String, String> studentAnswers);
    Evaluation ModuleEvaluation(String moduleId , String studentId  ) ;
    Evaluation findmodule(String testId, String studentId );
    Module assignTestToModule(String Moduleid, String testId);
    Evaluation assignStudentAndModuleToEvaluation(String evaluationId, String studentId , String ModuleId);

    List<Module> retrieveAllModule() ;

    void enhanceLevel(UserCourzelo student);
   void enhanceScoreXp(int totalMark , UserCourzelo student);
    UserCourzelo getStudentPerformanceStatistics(String studentId);
    List<Evaluation> retrieveEvaluationByUser( String studentId);
    UserCourzelo findStudent(String studentId);
    Integer silverBadges(String studentId);
    Integer goldBadges(String studentId);
    Integer bronzeBadges(String studentId);
    Integer dimondBadges(String studentId);

   Evaluation finalEvaluation(String studentId);
    List<Evaluation> finalsEvaluations();
  Evaluation getFinalEvaluation(String studentId);
  List<String > analysePerformanceStrengths(String studentId);
    List<String > analysePerformanceweakneses(String studentId);
    List<Module> analyseweakneses( String studentId);


}
