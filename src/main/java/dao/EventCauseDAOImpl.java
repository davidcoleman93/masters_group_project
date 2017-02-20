package dao;

import entities.EventCause;

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

}
