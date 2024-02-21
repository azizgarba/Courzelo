package tn.esprit.courzelo.Services.RecruitementService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.courzelo.Repositories.RecruitementRepo.JobOfferRepo;
import tn.esprit.courzelo.entities.RecruitementEntities.JobOffer;

import java.util.List;

@Service
@Slf4j

public class JobOfferServiceImpl implements IJobOfferService{
    @Autowired
    JobOfferRepo jobOfferRepo;
    @Override
    public List<JobOffer> getAlljobOffer() {
    try{
        return jobOfferRepo.findAll();
        } catch (Exception e){
        log.error(e.getMessage());
        return null;
        }
    }

    @Override
    public JobOffer getJobOfferByTitle(String title) {
        try {
            return jobOfferRepo.findByTitle(title);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public void addJobOffer(JobOffer jobOffer) {
        try{
        jobOfferRepo.save(jobOffer);

        } catch (Exception e){
        log.error(e.getMessage());

        }
    }

    @Override
    public void deleteJobOffer(String id) {
        try{
        jobOfferRepo.deleteById(id);

        } catch (Exception e){
        log.error(e.getMessage());

        }
    }

    @Override
    public void updateJobOffer(String id, JobOffer jobOffer) {
        try{
        jobOfferRepo.findById(id).ifPresent(jobOffer1 -> {
            jobOffer1.setTitle(jobOffer.getTitle());
            jobOffer1.setDescription(jobOffer.getDescription());
            jobOffer1.setSkills(jobOffer.getSkills());
            jobOffer1.setSpeciality(jobOffer.getSpeciality());
            jobOffer1.setExperience(jobOffer.getExperience());
            jobOfferRepo.save(jobOffer1);
        });

        } catch (Exception e){
        log.error(e.getMessage());

        }
    }

    @Override
    public JobOffer getJobOfferById(String id) {
        try{
        return jobOfferRepo.findById(id).get();

        } catch (Exception e){
        log.error(e.getMessage());
        return null;
        }
    }
}
