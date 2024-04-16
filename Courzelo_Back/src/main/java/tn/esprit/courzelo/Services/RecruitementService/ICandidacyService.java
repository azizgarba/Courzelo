package tn.esprit.courzelo.Services.RecruitementService;

import tn.esprit.courzelo.entities.RecruitementEntities.Candidacy;

import java.util.List;

public interface ICandidacyService {
    //get candidancies
    public List<Candidacy> getAllCandidacy();
    //get candidancy by id
    public Candidacy getCandidacyById(String id);
    //add candidancy
    public void addCandidacy(Candidacy candidacy,String jobOfferId);
    //delete candidancy
    public void deleteCandidacy(String id);
    //update candidancy
    public void updateCandidacy(String id,Candidacy candidacy);



}
