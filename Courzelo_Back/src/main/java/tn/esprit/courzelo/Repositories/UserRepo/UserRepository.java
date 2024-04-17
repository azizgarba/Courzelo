package tn.esprit.courzelo.Repositories.UserRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.courzelo.entities.ProjectEntities.Project;
import tn.esprit.courzelo.entities.UserCorzelo.ERole;
import tn.esprit.courzelo.entities.UserCorzelo.Role;
import tn.esprit.courzelo.entities.UserCorzelo.Speciality;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRepository extends MongoRepository<UserCourzelo,String> {
    UserCourzelo findUserCourzeloById(String id);
    Optional<UserCourzelo> findUserByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    List<UserCourzelo> findAllByRoles(Role role);




    List<UserCourzelo> findUserCourzeloByRolesAndSpecialityAndModule(Role role, Speciality speciality, String moduleName);
    //List<UserCourzelo> findByRole(Role role);

   // List<UserCourzelo> findBySpecialityAAndRoles(Speciality speciality, Role role) ;
    List<UserCourzelo> findUserCourzeloBySpecialityAndRoles(Speciality speciality, Role role);

    //List<Project> findProjectsByRolesAndId(Role role, String studentId);

}
