package tn.esprit.courzelo.Controllers.RecruitementController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.courzelo.Repositories.RecruitementRepo.CandidacyRepo;
import tn.esprit.courzelo.Services.RecruitementService.ICandidacyService;
import tn.esprit.courzelo.entities.RecruitementEntities.Candidacy;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/candidancy")
@Tag(name = "Candidancy")
public class CandidancyController {
    @Autowired
    CandidacyRepo candidacyRepo;
    @Autowired
    ICandidacyService candidacyService;
    //get all candidancy
    @GetMapping("/all")
    public ResponseEntity<List<Candidacy>> getAllCandidacy(){
        try{
            List<Candidacy> candidacies = candidacyService.getAllCandidacy();
            if(candidacies.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(candidacies);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    //get candidancy by id
    @GetMapping("/id/{id}")
    public ResponseEntity<Candidacy> getCandidacyById(@PathVariable("id") String id){
        try{
            Candidacy candidacy = candidacyService.getCandidacyById(id);
            if(candidacy == null){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(candidacy);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    //add candidancy
    @PostMapping("/add/{jobOfferId}")
    public ResponseEntity<String> addCandidacy( @RequestBody Candidacy candidacy, @PathVariable String jobOfferId){
        try{
            candidacyService.addCandidacy(candidacy, jobOfferId);
            return ResponseEntity.ok("Candidacy added successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    //delete candidancy
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCandidacy(@PathVariable String id){
        try{
            candidacyService.deleteCandidacy(id);
            return ResponseEntity.ok("Candidacy deleted successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    //update candidancy
    @PutMapping("/update/{id}")
public ResponseEntity<String> updateCandidacy(@PathVariable String id, @RequestBody Candidacy candidacy){
        try{
            candidacyService.updateCandidacy(id, candidacy);
            return ResponseEntity.ok("Candidacy updated successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().build();

        }
}
}
