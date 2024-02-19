package tn.esprit.courzelo.Repositories.RecruitementRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.courzelo.entities.RecruitementEntities.Candidacy;

@Repository
public interface CandidacyRepo extends MongoRepository<Candidacy, String> {
}
