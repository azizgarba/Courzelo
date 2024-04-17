package tn.esprit.courzelo.Services.ProjectService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.courzelo.Repositories.ProjectRepo.GroupProjectRepo;
import tn.esprit.courzelo.Repositories.ProjectRepo.ProjectRepo;
import tn.esprit.courzelo.Repositories.UserRepo.RoleRepository;
import tn.esprit.courzelo.Repositories.UserRepo.UserRepository;
import tn.esprit.courzelo.entities.ProjectEntities.GroupProject;
import tn.esprit.courzelo.entities.ProjectEntities.Project;
import tn.esprit.courzelo.entities.UserCorzelo.ERole;
import tn.esprit.courzelo.entities.UserCorzelo.Role;
import tn.esprit.courzelo.entities.UserCorzelo.Speciality;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class GroupProjectServiceImpl implements GroupProjectService {
    private final GroupProjectRepo groupProjectRepo;
    private final ProjectRepo projectRepo;
    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    @Override
    public List<GroupProject> Getgroups() {
        return groupProjectRepo.findAll();
    }

    public GroupProject addgroupAndAssignToproject(GroupProject groupProject, String id ) {
        GroupProject savedgroup = groupProjectRepo.save(groupProject);
        Project project = projectRepo.findById(id).orElseThrow(() ->
                new IllegalArgumentException("No Level Found with this id " +id));
        savedgroup.setProject(project);

        groupProjectRepo.save(savedgroup);
        return savedgroup;
    }

    @Override
    public void removegroup(String id) {
        groupProjectRepo.deleteById(id);
    }


    @Override
    public GroupProject updategroup(GroupProject groupProject) {
        return groupProjectRepo.save(groupProject);
    }

    @Override
    public GroupProject getById(String id) {
        return groupProjectRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("no  id " + id));
    }



    public void assignStudentsToGroup(String projectId) {
        Project project = projectRepo.findById(projectId).orElseThrow(() -> new IllegalArgumentException("No project found with id: " + projectId));

        // Create a list to store the required specialities and their respective number of students
        List<Map.Entry<Speciality, Integer>> requiredSpecialities = new ArrayList<>();
        for (Speciality speciality : project.getSpecialities()) {
            requiredSpecialities.add(new AbstractMap.SimpleEntry<>(speciality, 1));
        }

        // Retrieve students with matching specialities
        List<UserCourzelo> students = new ArrayList<>();

        for (Speciality speciality : project.getSpecialities()) {
            Role userRole = roleRepo.findByName(ERole.Student).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            System.out.println("****************" + userRole);
            Set<Role> Roles = new HashSet<>();
            Roles.add(userRole);
            List<UserCourzelo> students1= userRepo.findAllByRoles(userRole);
            List<UserCourzelo> studentsForSpeciality = userRepo.findUserCourzeloBySpecialityAndRoles(speciality,userRole);
            students.addAll(studentsForSpeciality);
        }
        System.out.println("****************" + students);

        // Create a new group
        GroupProject group = new GroupProject();
        group.setName("Group for Project: " + project.getName());
        group.setProject(project);

        // Assign students to the group based on required specialities
        for (Map.Entry<Speciality, Integer> entry : requiredSpecialities) {
            Speciality speciality = entry.getKey();
            int requiredStudents = entry.getValue();
            int assignedStudents = 0;
            Iterator<UserCourzelo> iterator = students.iterator();
            while (iterator.hasNext() && assignedStudents < requiredStudents) {
                UserCourzelo student = iterator.next();
                if (student.getSpeciality() == speciality) { // Changed from .equals to ==
                    group = addStudent(student,group);
                    iterator.remove(); // Remove assigned student from the list
                    assignedStudents++;
                }
            }
            if (assignedStudents < requiredStudents) {
                // Handle case where there are not enough students with the required speciality
                throw new RuntimeException("Not enough students with speciality: " + speciality);
            }
        }
        // Save the group to the database
        groupProjectRepo.save(group);
    }
    @Override
    public boolean isGroupAssignedToProject(String projectId) {
        // Implement logic to check if any group is assigned to the project
        return groupProjectRepo.existsByProjectId(projectId);
    }

    public List<GroupProject> getProjectsForUser(String studentId) {
        return groupProjectRepo.findByStudentsId(studentId);
    }
    public GroupProject addStudent(UserCourzelo student, GroupProject group) {

        Role userRole = roleRepo.findByName(ERole.Student).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        System.out.println("****************" + userRole);
        Set<Role> Roles = new HashSet<>();
        Roles.add(userRole);
        List<UserCourzelo> students= userRepo.findAllByRoles(userRole);
        students.add(student);
        /*if (student.getRoles() == Roles) {
            students.add(student);
        } else {
            throw new IllegalArgumentException("Only users with role 'Student' can be added to the group.");
        }*/
        group.setStudents(students);
        return group;
    }

}


