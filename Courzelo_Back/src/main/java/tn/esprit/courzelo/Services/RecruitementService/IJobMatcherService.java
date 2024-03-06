package tn.esprit.courzelo.Services.RecruitementService;

import tn.esprit.courzelo.entities.RecruitementEntities.JobOffer;

import java.util.List;

public interface IJobMatcherService {
    //match jobs
    public List<JobOffer> matchJobs(List<String> candidateSkills, List<String> candidateSpecialities, List<JobOffer> avaibleJobs);
    //calculate matching score
    public int calculateMatchingScore(List<String> candidateSkills, List<String> candidateSpecialities, JobOffer jobOffer);
    // calculate score
    public int calculateScore(List<String> candidateAttributes,List<String> jobAttributes, int weight);
}
