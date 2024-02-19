package tn.esprit.courzelo.Controllers.ForumController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.courzelo.Services.ForumService.QuestionForumImpl;
import tn.esprit.courzelo.entities.ForumEntities.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Tag(name = "ForumQuestion")
public class QuestionForumController {


}