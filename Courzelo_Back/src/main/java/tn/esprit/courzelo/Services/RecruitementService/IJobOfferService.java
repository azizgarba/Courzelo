package tn.esprit.courzelo.Services.RecruitementService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.courzelo.entities.RecruitementEntities.JobOffer;

import java.util.List;

public interface IJobOfferService {
    //get all job offer
    public List<JobOffer> getAlljobOffer();
    //get job offer by title
    public JobOffer getJobOfferByTitle(String title);
    // add job offer
    public void addJobOffer(JobOffer jobOffer, String idUser);
    //delete job offer
    public void deleteJobOffer(String id);
    //update job offer
    public void updateJobOffer(String id,JobOffer jobOffer);
    //get job offer by id
    public JobOffer getJobOfferById(String id);
}
