package tn.esprit.courzelo.Services.RecruitementService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.courzelo.Repositories.RecruitementRepo.CandidacyRepo;
import tn.esprit.courzelo.Repositories.RecruitementRepo.JobOfferRepo;
import tn.esprit.courzelo.Repositories.UserRepo.UserRepository;
import tn.esprit.courzelo.entities.RecruitementEntities.Candidacy;
import tn.esprit.courzelo.entities.RecruitementEntities.JobOffer;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j

public class CandidacyServiceImpl implements ICandidacyService  {
    @Autowired
    CandidacyRepo candidacyRepo;
    @Autowired
    JobOfferRepo jobOfferRepo;
    @Autowired
    UserRepository userRepo;
    @Override
    public List<Candidacy> getAllCandidacy() {
        try{
            return candidacyRepo.findAll();
        } catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Candidacy getCandidacyById(String id) {
        try {
            return candidacyRepo.findById(id).get();
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public void addCandidacy(Candidacy candidacy,String jobOfferId,String userId){
        try{
            UserCourzelo userCourzelo = userRepo.findUserCourzeloById(userId);
            JobOffer jobOffer = jobOfferRepo.findById(jobOfferId).orElseThrow(() -> new RuntimeException("Job offer not found"));
            List<JobOffer> jobOffers = new ArrayList<>();
            jobOffers.add(jobOffer);
            candidacy.setJobOffers(jobOffers);
            candidacy.setStudent(userCourzelo);
            candidacyRepo.save(candidacy);
        } catch (Exception e){
            log.error(e.getMessage());
        }
    }

    @Override
    public void deleteCandidacy(String id) {
        try{
            candidacyRepo.deleteById(id);

        } catch (Exception e){
            log.error(e.getMessage());

        }
    }

    @Override
    public void updateCandidacy(String id, Candidacy candidacy) {
        try{
            candidacyRepo.findById(id).ifPresent(candidacy1 -> {
                candidacy1.setDescription(candidacy.getDescription());
                candidacy1.setSkills(candidacy.getSkills());
                candidacy1.setExperience(candidacy.getExperience());
                candidacy1.setResume_candidacy(candidacy.getResume_candidacy());
                candidacyRepo.save(candidacy1);
            });

        } catch (Exception e){
            log.error(e.getMessage());

        }
    }
}
