package dao;

import entities.EventCause;
import entities.EventCauseID;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

/**
 * Created by david on 19/02/2017.
 */

@Local
@Stateless
public class EventCauseDAOImpl implements EventCauseDAOLocal {

    @PersistenceContext
    private EntityManager em;

    public Collection<?> getAllEventCauses(){
        return (List<EventCause>)em.createQuery("FROM EventCause ").getResultList();
    }

    public EventCause getEventCause(EventCauseID eventCauseID){
        return (EventCause)em.createQuery("SELECT o FROM EventCause o WHERE o.eventCauseID.causeCode=:eventCauseID")
                .setParameter("eventCauseID", eventCauseID)
                .getSingleResult();
    }

}
