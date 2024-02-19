package tn.esprit.courzelo.Repositories.RecruitementRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.courzelo.entities.RecruitementEntities.JobOffer;

@Repository
public interface JobOfferRepo extends MongoRepository<JobOffer, String> {
}
