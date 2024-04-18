package tn.esprit.courzelo.configurations;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tn.esprit.courzelo.Repositories.UserRepo.UserRepository;
import tn.esprit.courzelo.entities.UserCorzelo.User;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

@Component
public class DBInitializer implements CommandLineRunner {
    private final UserRepository userRepo;

    public DBInitializer(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepo.count() == 0) {
            User user = new User();
            userRepo.save(user);
        }
    }
}
