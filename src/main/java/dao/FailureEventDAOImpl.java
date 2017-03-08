package dao;

import entities.FailureEvent;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
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

	public Collection<?> getAllFailureEvents() {
		List<Object[]> objsFail = null;

	       try{
	           objsFail = (List<Object[]>)em
	                   .createQuery(
	                           "SELECT o.id, o.dateTime, o.eventCause.eventCauseID.causeCode, o.eventCause.eventCauseID.eventID, o.failureClass.failureClass, o.userEventType.tac, o.marketOperator.marketOpID.marketCode, o.marketOperator.marketOpID.operatorCode, o.cellID, o.duration, o.neVersion, o.imsi FROM FailureEvent o")
	                   .getResultList();
	       }catch(Exception e){
	           System.out.println("THERE IS A PROBLEM WITH THE QUERY");
	       }

	       return objsFail;
	}

	public void addFailureEvent(FailureEvent fe) {
		em.persist(fe);
	}
}
