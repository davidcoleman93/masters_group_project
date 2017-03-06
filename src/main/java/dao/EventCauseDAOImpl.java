package dao;

import entities.EventCause;
import entities.EventCauseID;

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

	public Collection<?> getAllEventCauses() {
		return em.createQuery("FROM EventCause ").getResultList();
	}

	public EventCause getEventCause(EventCauseID eventCauseID) {
		return (EventCause) em.createQuery("SELECT o FROM EventCause o WHERE o.eventCauseID=:eventCauseID")
				.setParameter("eventCauseID", eventCauseID).getSingleResult();
	}

	public boolean checkEventCause(EventCauseID eventCauseID) {
		// RETURN TRUE IF NOT FOUND
		return em.createQuery("SELECT o FROM EventCause o WHERE o.eventCauseID=:eventCauseID")
				.setParameter("eventCauseID", eventCauseID).setMaxResults(1).getResultList().isEmpty();
	}

}
