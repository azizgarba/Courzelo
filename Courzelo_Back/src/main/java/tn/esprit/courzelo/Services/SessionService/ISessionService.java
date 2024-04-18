package tn.esprit.courzelo.Services.SessionService;

import java.util.List;

public interface ISessionService <Session>{
    Session AddSession (Session session );
    Session Update(Session t);
    Session Retrieve(String id);
    List<Session> Retrieve();
    void Delete(String id);
}
