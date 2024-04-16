package tn.esprit.courzelo.Repositories.EvaluationRepo;


import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Module;
import tn.esprit.courzelo.entities.EvaluationEntities.Evaluation;
import tn.esprit.courzelo.entities.EvaluationEntities.EvaluationType;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.List;

public interface EvaluationRepo extends MongoRepository<Evaluation, String> {
    Evaluation findEvaluationByModuleAndAndStudent(Module module , UserCourzelo student);
  List <Evaluation> findByStudent(UserCourzelo student) ;
    List <Evaluation>   findAllByStudentAndEvaluationType(UserCourzelo student ,EvaluationType type);
    Evaluation findByStudentAndEvaluationType(UserCourzelo student ,EvaluationType type);
}