package tn.esprit.courzelo.Controllers.RecruitementController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.courzelo.Repositories.RecruitementRepo.CandidacyRepo;

@RestController
@AllArgsConstructor
@RequestMapping("/candidancy")
@Tag(name = "Candidancy")
public class CandidancyController {
    @Autowired
    CandidacyRepo candidacyRepo;


}
