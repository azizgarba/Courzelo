package tn.esprit.courzelo.Services.SessionService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.courzelo.Repositories.SessionRepo.NotifRepo;
import tn.esprit.courzelo.entities.SessionEntities.Notif;

import java.util.List;

@Service
@AllArgsConstructor
public class NotifServiceImpl implements INotifService<Notif>{

    private final NotifRepo repo;
    @Override
    public Notif AddNotif(Notif Notif) {
        return repo.save(Notif);
    }

    @Override
    public Notif Update(Notif t) {
        return repo.save(t);
    }

    @Override
    public Notif Retrieve(String id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Notif> Retrieve() {
        return repo.findAll();
    }

    @Override
    public void Delete(String id) {
        repo.deleteById(id);
    }
}
