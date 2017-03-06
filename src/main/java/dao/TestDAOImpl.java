package dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

/**
 * Created by C06590861 on 15/02/2017.
 */

@Local
@Stateless
public class TestDAOImpl implements TestDAOLocal {

	@PersistenceContext
	private EntityManager em;

	public void addRecord(Object o) {
		// em.persist();
	}

	// WORKING QUERY
	// Retrieving all records from event_causes table
	/*
	 * public Collection<EventCause> getAll(){ return
	 * (List<EventCause>)em.createQuery("FROM EventCause").getResultList() ; }
	 */

	public Collection<?> getAll() {
		System.out.println("QUERY!!!");
		return em.createQuery("FROM FailureEvent").getResultList();
	}

}
