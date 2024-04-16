package tn.esprit.courzelo.Repositories.ForumRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.courzelo.entities.ForumEntities.BadgeForumTeacher;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.List;

public interface BadgeForumTeacherRepos extends MongoRepository<BadgeForumTeacher,String> {
    List<BadgeForumTeacher> findBadgeForumTeacherByTeacherOrderByDateDesc(UserCourzelo u);

}
