package dao;

import entities.FailureClass;

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
public class FailureClassDAOImpl implements FailureClassDAOLocal {

	@PersistenceContext
	private EntityManager em;

	public Collection<?> getAllFailureClasses() {
		return em.createQuery("FROM FailureClass ").getResultList();
	}

	public FailureClass getFailureClass(Integer failureClass) {
		return (FailureClass) em.createQuery("SELECT o FROM FailureClass o WHERE o.failureClass=:failureClass")
				.setParameter("failureClass", failureClass).getSingleResult();

	}

	public boolean checkFailureClass(Integer failureClass) {
		// RETURN TRUE IF NOT FOUND
		return em.createQuery("SELECT o FROM FailureClass o WHERE o.failureClass=:failureClass")
				.setParameter("failureClass", failureClass).setMaxResults(1).getResultList().isEmpty();
	}

}
