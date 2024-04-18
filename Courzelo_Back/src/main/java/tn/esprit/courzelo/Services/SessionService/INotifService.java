package tn.esprit.courzelo.Services.SessionService;

import java.util.List;

public interface INotifService <Notif> {
    Notif AddNotif (Notif Notif );
    Notif Update(Notif t);
    Notif Retrieve(String id);
    List<Notif> Retrieve();
    void Delete(String id);
}
