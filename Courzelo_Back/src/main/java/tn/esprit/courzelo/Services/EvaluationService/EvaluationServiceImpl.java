package tn.esprit.courzelo.Services.EvaluationService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.courzelo.Repositories.EvaluationRepo.EvaluationRepo;
import tn.esprit.courzelo.Repositories.EvaluationRepo.TestRepo;
import tn.esprit.courzelo.Repositories.ModuleRepo.ModuleRepo;
import tn.esprit.courzelo.Repositories.UserRepo.UserRepo;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Module;
import tn.esprit.courzelo.entities.EvaluationEntities.*;
import tn.esprit.courzelo.entities.UserCorzelo.Role;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;
import tn.esprit.courzelo.entities.UserCorzelo.badgeType;

import java.util.*;

import static tn.esprit.courzelo.entities.EvaluationEntities.EvaluationType.FinalEvaluation;
import static tn.esprit.courzelo.entities.EvaluationEntities.EvaluationType.ModuleEvaluation;

@AllArgsConstructor
@Service
public class EvaluationServiceImpl implements IEvaluationService{
    private TestRepo testRepo ;
    private ModuleRepo moduleRepo ;
    private EvaluationRepo evaluationRepo;
    private UserRepo studentRepo;

    @Override
    public List<Evaluation> retrieveAllEvaluations() {
        return evaluationRepo.findAll();
    }

    @Override
    public Evaluation addEvaluation(String moduleId , String studentId ,Evaluation evaluation) {
        Module module = moduleRepo.findById(moduleId).orElseThrow();
        UserCourzelo student = studentRepo.findById(studentId).orElseThrow();
        evaluation.setModule(module);
        evaluation.setStudent(student);
        return evaluationRepo.save(evaluation);
    }

    @Override
    public Evaluation updateEvaluation(Evaluation evaluation) {
        return evaluationRepo.save(evaluation);
    }

    @Override
    public Evaluation retrieveEvaluation(String idEvaluation) {
        return evaluationRepo.findById(idEvaluation).orElseThrow();
    }

    @Override
    public void removeEvaluation(String idEvaluation) {
        evaluationRepo.deleteById(idEvaluation);
    }

    @Override
    public Evaluation takeTest(  String testId, String studentId ,Map<String, String> studentAnswers) {
        Test test = testRepo.findById(testId).orElseThrow();
        UserCourzelo student = studentRepo.findById(studentId).orElseThrow();
        Module module = moduleRepo.findModuleByTests(test);
        Evaluation evaluation = evaluationRepo.findEvaluationByModuleAndAndStudent(module, student);
        if (evaluation == null) {
            evaluation = new Evaluation();
            evaluation.setEvaluationType(ModuleEvaluation);
            addEvaluation(module.getId(), studentId,evaluation);
        }
        int totalMark = 0;
        for (QuestionTest question : test.getQuestions()) {
            String correctAnswer = question.getCorrectAnswer();
            String studentAnswer = studentAnswers.get(question.getId());
            if (studentAnswer != null && studentAnswer.equals(correctAnswer)) {
                totalMark += 2;
            }
        }
            if (test.getType() == Type.QuizTest) {
                evaluation.setQuizGrade(totalMark);
            } else if (test.getType() == Type.FinalTest) {
                evaluation.setFinaltest_grade(totalMark);
            }
            enhanceScoreXp(totalMark,student);
            enhanceLevel(student);

            return evaluationRepo.save(evaluation);

    }
@Override
    public Evaluation ModuleEvaluation(String moduleId, String studentId) {
        Module module = moduleRepo.findById(moduleId).orElseThrow();
        UserCourzelo student =studentRepo.findById(studentId).orElseThrow();
        Evaluation evaluation = evaluationRepo.findEvaluationByModuleAndAndStudent(module,student);
       int    quizGrade = evaluation.getQuizGrade();
       int finalTestGrade = evaluation.getFinaltest_grade();
        double moduleAverage= 0 ;
      moduleAverage= finalTestGrade * 0.6 + quizGrade * 0.4 ;
        evaluation.setModuleAverage(moduleAverage);
    if(moduleAverage<10){
        evaluation.setComments("Unsatisfactory");
    }
    else if(moduleAverage==10){
        evaluation.setComments("Satisfactory");
    }
    if((moduleAverage<=15) &(moduleAverage>10)){
        evaluation.setComments("Commendable");
    }
    if((moduleAverage>15)){
        evaluation.setComments("Outstanding");
    }
        return evaluationRepo.save(evaluation);

    }

    @Override
    //methode de test
    public Evaluation findmodule(String testId, String studentId ) {
        UserCourzelo student = studentRepo.findById(studentId).orElseThrow();
        Test test = testRepo.findById(testId).orElseThrow();
        Module module = moduleRepo.findModuleByTests(test);
        Evaluation evaluation = evaluationRepo.findEvaluationByModuleAndAndStudent(module ,student);

        return evaluation ;
    }


    @Override
    public Module assignTestToModule(String moduleId, String testId) {
       Module module =moduleRepo.findById(moduleId).orElseThrow();
       Test test = testRepo.findById(testId).orElseThrow();
        if (module.getTests() == null) {
            module.setTests(new ArrayList<>());}
       module.getTests().add(test);
        return moduleRepo.save(module);
    }

    @Override
    public Evaluation assignStudentAndModuleToEvaluation(String evaluationId, String studentId, String moduleId) {
       Evaluation evaluation = evaluationRepo.findById(evaluationId).orElseThrow();
       UserCourzelo student = studentRepo.findById(studentId).orElseThrow();
        Module module =moduleRepo.findById(moduleId).orElseThrow();
        evaluation.setStudent(student);
        evaluation.setModule(module);
        return evaluationRepo.save(evaluation) ;
    }


    @Override
    public List<Module> retrieveAllModule() {
        return moduleRepo.findAll();
    }


    @Override
    public void enhanceLevel(UserCourzelo student) {
        if (student.getBadges() == null) {
            student.setBadges(new ArrayList<>());}

        if (student.getLevel()==20){
          student.getBadges().add(badgeType.SILVER);
        }
        else if(student.getLevel()==50){
            student.getBadges().add(badgeType.GOLD);
        }
        else if(student.getLevel()==100){
            student.getBadges().add(badgeType.DIMOND);
        }
        studentRepo.save(student);

    }


    @Override
    public void enhanceScoreXp(int totalMark, UserCourzelo student) {
        float threshold = 10;
        float newscoreXp = 0;
        int newlevel = 0;
        if(totalMark> threshold){
            newscoreXp= student.getScoreXp() +(totalMark-threshold) ;
            student.setScoreXp(newscoreXp);
            studentRepo.save(student);
            if(newscoreXp>=100){
                newlevel= student.getLevel()+1;
                student.setLevel(newlevel);
                student.setScoreXp(newscoreXp-100);
                studentRepo.save(student);
            }
        }
    }


    @Override
    public UserCourzelo getStudentPerformanceStatistics(String studentId) {
            UserCourzelo student = studentRepo.findById(studentId).orElseThrow();
            UserCourzelo statistics = new UserCourzelo();
            statistics.setScoreXp(student.getScoreXp());
            statistics.setLevel(student.getLevel());
            statistics.setBadges(student.getBadges());
            return statistics;
        }

    @Override
    public List<Evaluation> retrieveEvaluationByUser(String studentId) {
UserCourzelo student = studentRepo.findById(studentId).orElseThrow();
        List<Evaluation> evaluations = evaluationRepo.findAllByStudentAndEvaluationType(student , ModuleEvaluation) ;
        return evaluations ;

    }


    @Override
    public UserCourzelo findStudent(String studentId) {
        return studentRepo.findById(studentId).orElseThrow();
    }



    @Override
    public Integer silverBadges(String studentId) {
        UserCourzelo student =studentRepo.findById(studentId).orElseThrow();
int silverBadges =0;
 for (badgeType badge : student.getBadges() )
        if(badge==badgeType.SILVER)
            silverBadges+= 1 ;
        return silverBadges;
    }


    @Override
    public Integer goldBadges(String studentId) {
        UserCourzelo student =studentRepo.findById(studentId).orElseThrow();
        int goldBadges =0;
        for (badgeType badge : student.getBadges() )
            if(badge==badgeType.GOLD)
                goldBadges+= 1 ;
        return goldBadges;
    }

    @Override
    public Integer bronzeBadges(String studentId) {
        UserCourzelo student =studentRepo.findById(studentId).orElseThrow();
        int bronzeBadges =0;
        for (badgeType badge : student.getBadges() )
            if(badge==badgeType.BRONZE)
                bronzeBadges+= 1 ;
        return bronzeBadges;
    }
    @Override
    public Integer dimondBadges(String studentId) {
        UserCourzelo student =studentRepo.findById(studentId).orElseThrow();
        int dimond =0;
        for (badgeType badge : student.getBadges() )
            if(badge==badgeType.DIMOND)
                dimond+= 1 ;
        return dimond;
    }


    @Override
    public Evaluation finalEvaluation(String studentId) {
        Evaluation evaluation = new Evaluation();
        evaluation.setEvaluationType(FinalEvaluation);
        UserCourzelo student = studentRepo.findById(studentId).orElseThrow();
        evaluation.setStudent(student);
        float coef ;
        float totcoeff=0 ;
        double moduleavg ;
        double finalav = 0;
        long q ;
        List<Evaluation> evaluations = retrieveEvaluationByUser(studentId);
        for(Evaluation ev : evaluations){
          coef = ev.getModule().getCoeff();
          moduleavg = ev.getModuleAverage();
            finalav += (coef*moduleavg);
            totcoeff += coef;
        }
        evaluation.setFinalAverage(finalav/totcoeff);
        if(evaluation.getFinalAverage()<10){
            evaluation.setHonors("Grade f");
        }
        else if(evaluation.getFinalAverage()==10){
            evaluation.setHonors("Grade D");
        }
        else if((evaluation.getFinalAverage()<=15) &(evaluation.getFinalAverage()>10)){
            evaluation.setHonors("Grade C");
        }
        else if((evaluation.getFinalAverage()>15)&(evaluation.getFinalAverage()<18)){
            evaluation.setHonors("Grade B");
        }
        else if(evaluation.getFinalAverage()>18){
            evaluation.setHonors("Grade A");
        }
        return evaluationRepo.save(evaluation);
    }

    @Override
    public List<Evaluation> finalsEvaluations() {
      List<UserCourzelo> students =studentRepo.findAllByRole(Role.Student) ;
        List<Evaluation> finals = new ArrayList<>() ;
      for (UserCourzelo student : students)
      {
          Evaluation  ev = finalEvaluation(student.getId());
          finals.add(ev);
      }
        return finals ;
    }

    @Override
    public Evaluation getFinalEvaluation(String studentId) {
        UserCourzelo student = studentRepo.findById(studentId).orElseThrow();
        Evaluation evaluation =evaluationRepo.findByStudentAndEvaluationType(student, FinalEvaluation);
        return evaluation;
    }

    @Override
    public List<String> analysePerformanceStrengths(String studentId) {
       List<Evaluation> evaluations= retrieveEvaluationByUser(studentId);
        List<String> strengths = new ArrayList<>();
        for(Evaluation e : evaluations){
            if(e.getModuleAverage()>15){
                strengths.add(e.getModule().getName());
            }
        }
        return strengths;
     }

    @Override
    public List<String>  analysePerformanceweakneses(String studentId) {
        UserCourzelo student = studentRepo.findById(studentId).orElseThrow();
        List<Evaluation> evaluations= retrieveEvaluationByUser(studentId);
        List<String> weakneses = new ArrayList<>();
        for(Evaluation e : evaluations){
            if(e.getModuleAverage()<10){
                weakneses.add(e.getModule().getName());
            }
        }
        return weakneses;
    }


    @Override
    public List<Module>  analyseweakneses(String studentId) {
        UserCourzelo student = studentRepo.findById(studentId).orElseThrow();
        List<String>  weaknesses =analysePerformanceweakneses(studentId);
        String level = "";
        int lev = 0;
        String l="";
        Module mod = new Module();
        List<Module> modules = new ArrayList<>();
      for(String e : weaknesses){
          for (Module module :student.getClasse().getModules() )
              if (e==module.getName()){
                   level= student.getClasse().getLevel().getName();
                   lev = Integer.parseInt(level);
                  lev=lev-1;
                   l=String.valueOf(level); }
                  mod = moduleRepo.findModuleByLevelName(l);
              }
           modules.add(mod);
        return modules;
    }

}


