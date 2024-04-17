package tn.esprit.courzelo.Controllers.UserController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.courzelo.Repositories.UserRepo.RoleRepository;
import tn.esprit.courzelo.Repositories.UserRepo.UserRepository;
import tn.esprit.courzelo.Services.UserService.UserDetailsImpl;
import tn.esprit.courzelo.entities.UserCorzelo.*;
import tn.esprit.courzelo.request.LoginRequest;
import tn.esprit.courzelo.request.SignUpRequest;
import tn.esprit.courzelo.security.JwtUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;



@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    AuthenticationManager authenticationManager;


    UserRepository userRepository;


    RoleRepository roleRepository;


    PasswordEncoder encoder;


    JwtUtils jwtUtils;

   // private String savedToken;
   /* public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository,
                          RoleRepository roleRepository, PasswordEncoder encoder, JwtUtils jwtUtils) {
        super();
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
    }*/
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        try {
            // Authentification de l'utilisateur
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

            // Définition de l'authentification dans le contexte de sécurité
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Récupération des détails de l'utilisateur
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            // Génération du token JWT
            String jwtToken = jwtUtils.generateTokenFromUsername(userDetails.getUsername());

            // Génération du cookie JWT et ajout à la réponse
            ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(jwtToken);

            // Récupération des rôles de l'utilisateur
            List<String> roles = userDetails.getAuthorities().stream()
                    .map(item -> item.getAuthority())
                    .collect(Collectors.toList());
            System.out.println("token : "+jwtToken);
            //this.savedToken=jwtToken;
            System.out.println("email : "+userDetails.getEmail());

            //emailService.sendEmail(userDetails.getEmail(), "Veirfication du Connexion", "Votre token de connexion : "+jwtToken);


            // Retour de la réponse avec le cookie JWT et les informations de l'utilisateur
            return ResponseEntity.ok()
                    .header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                    .header("Authorization", "Bearer " + jwtToken) // Add token to response header
                    .body(new UserInfoResponse(userDetails.getId(),
                            userDetails.getUsername(),
                            userDetails.getEmail() ,
                            jwtToken, roles
                           ));
        } catch (Exception e) {
            // Gérer les exceptions et renvoyer une réponse d'erreur
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Error while authenticating user: " + e.getMessage()));
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        UserCourzelo user = new UserCourzelo(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<ERole> strRoles = signUpRequest.getRoles();
        Set<Role> roles = new HashSet<>();
        System.out.println("roles : "+strRoles);
        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.Student)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case Admin:
                        Role adminRole = roleRepository.findByName(ERole.Admin)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;
                    case Teacher:
                        Role teacherRole = roleRepository.findByName(ERole.Teacher)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(teacherRole);
                        break;
                    case Student:
                        Role studentRole = roleRepository.findByName(ERole.Student)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(studentRole);
                        break;
                    case Moderator:
                        Role moderatorRole = roleRepository.findByName(ERole.Moderator)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(moderatorRole);
                        break;
                    case Recruiter:
                        Role recruiterRole = roleRepository.findByName(ERole.Recruiter)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(recruiterRole);
                        break;
                    default:
                        throw new RuntimeException("Error: Invalid Role!");
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }



}
