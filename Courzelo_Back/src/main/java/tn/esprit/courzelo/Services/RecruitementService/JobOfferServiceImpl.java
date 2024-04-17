package tn.esprit.courzelo.Services.RecruitementService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.courzelo.Repositories.RecruitementRepo.JobOfferRepo;
import tn.esprit.courzelo.Repositories.UserRepo.UserRepository;
import tn.esprit.courzelo.entities.RecruitementEntities.JobOffer;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.util.List;

@Service
@Slf4j

public class JobOfferServiceImpl implements IJobOfferService{
    @Autowired
    JobOfferRepo jobOfferRepo;
    @Autowired
    IResumeParserService resumeParserService;
    @Autowired
    IJobMatcherService jobMatcherService;
    @Autowired
    UserRepository userRepo;
    String path = "D:\\Esprit\\3eme\\documents internship\\test3.pdf";
    @Override
    public List<JobOffer> getAlljobOffer() {
    try{
        List<String> parsedEntities=resumeParserService.parseResume(path);
        // Get all available jobs
        List<JobOffer> availableJobs = jobOfferRepo.findAll();
        //debugging available jobs
        System.out.println(availableJobs);
        // list of skills
        System.out.println(resumeParserService.identifySkills(parsedEntities));
        // list of specialities
        System.out.println(resumeParserService.identifySpecialities(parsedEntities));
        // Match jobs
        List<JobOffer> matchedJobs = jobMatcherService.matchJobs(resumeParserService.identifySkills(parsedEntities),resumeParserService.identifySpecialities(parsedEntities), availableJobs);
        //debugging matched jobs
        System.out.println(matchedJobs);
        return matchedJobs;
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
    public void addJobOffer(JobOffer jobOffer, String idUser) {
        try{
        UserCourzelo userCourzelo = userRepo.findUserCourzeloById(idUser);
        jobOffer.setRecruiter(userCourzelo);
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
