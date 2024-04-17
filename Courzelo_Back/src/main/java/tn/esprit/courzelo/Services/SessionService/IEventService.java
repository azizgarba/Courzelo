package tn.esprit.courzelo.Services.SessionService;

import tn.esprit.courzelo.entities.SessionEntities.Event;

import java.util.List;

public interface IEventService<Event> {
    Event AddEvent (Event session );
    Event Update(Event t);
    Event Retrieve(String id);
    List<Event> Retrieve();
    void Delete(String id);
}
