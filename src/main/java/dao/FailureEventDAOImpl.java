package dao;

import entities.FailureEvent;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Collection;
import java.util.List;

/**
 * Created by C06590861 on 16/02/2017.
 */

@Local
@Stateless
public class FailureEventDAOImpl implements FailureEventDAOLocal {

    @PersistenceContext
    private EntityManager em;

    public Collection<?> getAllFailureEvents(){
        return (List<FailureEvent>)em.createQuery("FROM FailureEvent ").getResultList();
    }

	public void addFailEvent(FailureEvent fEvent) {
			em.persist(fEvent);
			
	}

}
