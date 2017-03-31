package dao;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import entities.EventCause;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

/**
 * Created by david on 19/02/2017.
 */

@Local
@Stateless
public class EventCauseDAOImpl implements EventCauseDAOLocal {

    @PersistenceContext
    private EntityManager em;

    public Multimap<Integer, Integer> getEventCauseMap(){
        List<Object[]> temp = (List<Object[]>)
                em.createQuery("SELECT o.eventCauseID.causeCode, o.eventCauseID.eventID FROM EventCause o").getResultList();

        Multimap<Integer, Integer> map = ArrayListMultimap.create();
        for(Object[] t : temp) {
            map.put((Integer) t[0], (Integer) t[1]);
        }

        return map;
    }

    public void addEventCause(EventCause eventCause){
        em.persist(eventCause);
    }
}
