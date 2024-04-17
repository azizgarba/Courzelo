package tn.esprit.courzelo.Repositories.UserRepo;

import org.apache.catalina.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import tn.esprit.courzelo.entities.ForumEntities.QuestionForum;
import tn.esprit.courzelo.entities.ProjectEntities.Project;
import tn.esprit.courzelo.entities.UserCorzelo.Role;
import tn.esprit.courzelo.entities.UserCorzelo.Speciality;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.List;

public interface UserRepo  extends MongoRepository<UserCourzelo,String> {
   // UserCourzelo findByRole(UserCourzelo Teacher);


   // List<UserCourzelo>  findUserCourzeloByRole_Teacher (List<UserCourzelo> userCourzelos) ;
    //List<UserCourzelo> findByRoleAndModuleName(Role role, String moduleName);
  // @Query("{'role': ?0, 'modules.name': ?1}")
  // List<UserCourzelo> findTeachersByRoleAndModuleName(Role role, String moduleName);
  //  List<UserCourzelo> findUserCourzeloByRoleAndSpeciality(Role role, Speciality speciality);
  List<UserCourzelo> findUserCourzeloByRoleAndSpecialityAndModule(Role role, Speciality speciality, String moduleName);
    List<UserCourzelo> findByRole(Role role);
 UserCourzelo findUserCourzeloById(String id );
    List<UserCourzelo> findBySpeciality(Speciality speciality);
    List<Project> findProjectsByRoleAndId(Role role, String studentId);

}
