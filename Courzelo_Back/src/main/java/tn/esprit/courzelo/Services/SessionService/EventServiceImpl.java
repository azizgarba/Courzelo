package tn.esprit.courzelo.Services.SessionService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.courzelo.Repositories.SessionRepo.EventRepo;
import tn.esprit.courzelo.Repositories.SessionRepo.RsvpRepo;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Module;
import tn.esprit.courzelo.entities.SessionEntities.Event;
import tn.esprit.courzelo.entities.SessionEntities.Rsvp;

import java.util.List;

@Service
@AllArgsConstructor
public class EventServiceImpl implements  IEventService<Event>{

    private final EventRepo repo;
    private final RsvpRepo rsvpRepo;
    @Override
    public Event AddEvent(Event event) {
        return repo.save(event);
    }

    @Override
    public Event Update(Event t) {
        return repo.save(t);
    }

    @Override
    public Event Retrieve(String id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Event> Retrieve() {
        return repo.findAll();
    }

    @Override
    public void Delete(String id) {
        repo.deleteById(id);
    }

    public Event GetEstimation(Event event){

        //Event event = repo.findByName(name);
        System.out.println(event);



        List<Rsvp> list = rsvpRepo.findAll();
        System.out.println("list : "+list);
        // Considering the Rsvp
        float somme =0;
        for(Rsvp r : list){
            if(r.getStatus().equals("Interested")){
                somme+=1;
            }else if(r.getStatus().equals("Maybe")){
                somme+= 0.5F;
            }
            System.out.println(r.getStatus());
        }
        System.out.println("Somme : "+somme);
        //Considering the Category of the event
        List<Rsvp> listall = rsvpRepo.findAll();
        int countCategory = 0;
        for(Rsvp r : listall){
            if(r.getEvent().getCategory().equals(event.getCategory())|| r.getEvent().getId().equals(event.getId())){
                countCategory+=1;
            }
        }

        float percCat = ((float) countCategory /listall.size())*10;
        System.out.println("percCat : "+percCat);
        float estimation = ((somme/list.size())*100)+percCat;
        // Consedering the event price
        double pricemoy = 0;
        List<Event> events = repo.findAll();
        for(Event r : events){
            pricemoy= pricemoy +r.getPrice();
        }
        pricemoy = pricemoy / listall.size();
        if(event.getPrice() > pricemoy){
            float added = 0;
            added = (float) (event.getPrice()-pricemoy);
            estimation -=added;
        }else{
            float added = 0;
            added = (float) (pricemoy-event.getPrice());
            estimation +=added;
        }
        System.out.println("Estimation : "+ estimation);
        event.setEstimation(estimation);
        repo.save(event);
        return event;
    }

    public void GetAllEstimation(){

        List<Event> events = repo.findAll();

        for(Event event : events){

            //Event event = repo.findByName(name);
            System.out.println(event);



            List<Rsvp> list = rsvpRepo.findAll();
            System.out.println("list : "+list);
            // Considering the Rsvp
            float somme =0;
            for(Rsvp r : list){
                if(r.getStatus().equals("Interested")){
                    somme+=1;
                }else if(r.getStatus().equals("Maybe")){
                    somme+= 0.5F;
                }
                System.out.println(r.getStatus());
            }
            System.out.println("Somme : "+somme);
            //Considering the Category of the event
            List<Rsvp> listall = rsvpRepo.findAll();
            int countCategory = 0;
            for(Rsvp r : listall){
                if(r.getEvent().getCategory().equals(event.getCategory())|| r.getEvent().getId().equals(event.getId())){
                    countCategory+=1;
                }
            }

            float percCat = ((float) countCategory /listall.size())*10;
            System.out.println("percCat : "+percCat);
            float estimation = ((somme/list.size())*100)+percCat;
            // Consedering the event price
            double pricemoy = 0;
            //List<Event> events = repo.findAll();
            for(Event r : events){
                pricemoy= pricemoy +r.getPrice();
            }
            pricemoy = pricemoy / listall.size();
            if(event.getPrice() > pricemoy){
                float added = 0;
                added = (float) (event.getPrice()-pricemoy);
                estimation -=added;
            }else{
                float added = 0;
                added = (float) (pricemoy-event.getPrice());
                estimation +=added;
            }
            System.out.println("Estimation : "+ estimation);
            event.setEstimation(estimation);
            repo.save(event);

        }
    }

}
