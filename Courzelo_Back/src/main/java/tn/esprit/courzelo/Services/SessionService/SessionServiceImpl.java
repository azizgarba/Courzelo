package tn.esprit.courzelo.Services.SessionService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.courzelo.Repositories.AcademicProgramRepo.ClassRepo;
import tn.esprit.courzelo.Repositories.ModuleRepo.ModuleRepo;
import tn.esprit.courzelo.Repositories.SessionRepo.SessionRepo;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Class;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Module;
import tn.esprit.courzelo.entities.SessionEntities.Session;
import tn.esprit.courzelo.entities.SessionEntities.TypeSession;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
@AllArgsConstructor
public class SessionServiceImpl implements ISessionService<Session>{

    private final SessionRepo repo;
    private final ModuleRepo mrepo;
    private final ClassRepo crepo;
    @Override
    public Session AddSession(Session session) {
        return repo.save(session);
    }

    @Override
    public Session Update(Session t) {
        return repo.save(t);
    }

    @Override
    public Session Retrieve(String id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Session> Retrieve() {
        return repo.findAll();
    }

    @Override
    public void Delete(String id) {
        repo.deleteById(id);
    }

    public List<Session> RetrieveByClass(String name) {
        List<Session> all = repo.findAll();
        List<Session> list = new ArrayList<>();
        for (Session s: all) {
            System.out.println(s.getAClass().getName());
            if(s.getAClass().getName().equals(name)){
                list.add(s);
            }
        }
        return list;
    }



    // Generating Schedule
    public List<Session> createScedule(LocalDateTime startDate){

        List<Class> classes = new ArrayList<>();
        List<Module> Modules = new ArrayList<>();
        // filling the lists with test data
        Class c1 = new Class();
        Class c2 = new Class();
        c1.setName("4SAE5");
        c1.setId("4SAE5");
        c2.setName("4SAE6");
        c2.setId("4SAE6");
        Module m1 =new Module();
        Module m2 =new Module();
        m1.setName("SpringBoot");
        m1.setId("SpringBoot");
        m2.setName("Angular");
        m2.setId("Angular");
        UserCourzelo t1 = new UserCourzelo();
        UserCourzelo t2 = new UserCourzelo();
        t1.setFirstName("Semer");
        t1.setId("semer");
        t2.setFirstName("mohsen");
        t2.setId("mohsen");
        List<UserCourzelo> l = new ArrayList<>();
        l.add(t1);
        m1.setTeachers(l);
        List<UserCourzelo> l2 = new ArrayList<>();
        l2.add(t2);
        m2.setTeachers(l2);
        classes.add(c1);
        classes.add(c2);
        Modules.add(m1);
        Modules.add(m2);

        // generating the schedule
        List<Session> schedule = new ArrayList<>();
        Iterator<Class> ic = classes.iterator();
        while( ic.hasNext() ){
            Class c = ic.next();
            long day = 1;
            int temp = 1;
            for(Module m : Modules){
                //Session s = new Session();
                int indexTeacher = 0;
                UserCourzelo t = m.getTeachers().get(indexTeacher);
                if(schedule.isEmpty() || schedule.size() == 0){
                    Session news = new Session();
                    news.setTeacher(t);
                    news.setDay(day);
                    news.setTemp(temp);
                    news.setAClass(c);
                    news.setTypeSession(TypeSession.Course);
                    news.setModule(m);
                    LocalDateTime date = startDate;
                    date = date.plusDays(day-1);
                    date = switch (temp) {
                        case 1 -> date.withHour(8);
                        case 2 -> date.withHour(10);
                        case 3 -> date.withHour(13);
                        case 4 -> date.withHour(15);
                        default -> date;
                    };

                    news.setDate(date.withMinute(0));
                    System.out.println(date);
                    schedule.add(news);

                }else{
                    ListIterator<Session> iterator = schedule.listIterator();
                    while( iterator.hasNext() ){
                        Session ss = iterator.next();
                        if(ss.getTeacher() == t){

                            if(indexTeacher == m.getTeachers().size()-1){
                                if(temp <= 4){
                                    temp= temp + 1;
                                }else { day =day + 1 ; temp=1; }
                            }else{
                                indexTeacher+=1;
                                t = m.getTeachers().get(indexTeacher);
                            }

                        }else {
                            Session news = new Session();
                            news.setTeacher(t);
                            news.setDay(day);
                            news.setTemp(temp);
                            news.setAClass(c);
                            news.setTypeSession(TypeSession.Course);
                            news.setModule(m);
                            LocalDateTime date = startDate;
                            date = date.plusDays(day);
                            date = switch (temp) {
                                case 1 -> date.withHour(8);
                                case 2 -> date.withHour(10);
                                case 3 -> date.withHour(13);
                                case 4 -> date.withHour(15);
                                default -> date;
                            };
                            System.out.println(date);
                            news.setDate(date);
                            iterator.add(news);
                        }
                    }
                }
            }
        }
        repo.saveAll(schedule);
        return schedule;
    }
}
