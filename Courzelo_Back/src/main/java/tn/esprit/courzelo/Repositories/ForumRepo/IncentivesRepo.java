package tn.esprit.courzelo.Repositories.ForumRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.courzelo.entities.ForumEntities.Incentives;
import tn.esprit.courzelo.entities.ForumEntities.IncentivesType;
import tn.esprit.courzelo.entities.ForumEntities.Votes;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.List;

public interface IncentivesRepo  extends MongoRepository<Incentives,String> {
//t<Incentives> findIncentivesByOrderByDateOFObtainingDesc();
//Incentives findFirstByOrderByDateOFObtainingDesc();
    //Incentives findFirstByIncentivesTypeOrderByDateOFObtainingDesc(IncentivesType ins);
    Incentives findFirstByTeacherAndIncentivesTypeOrderByDateOFObtainingDesc(UserCourzelo u, IncentivesType ins );
    //List<Incentives> findFirst5ByIncentivesTypeOrderByDateOFObtainingDesc(IncentivesType ins);
    List<Incentives> findFirst5ByTeacherAndIncentivesTypeOrderByDateOFObtainingDesc(UserCourzelo u ,IncentivesType ins);

    List<Incentives> findIncentivesByTeacherOrderByDateOFObtainingDesc(UserCourzelo u);
    long countAllByIncentivesType(IncentivesType ins) ;

}
