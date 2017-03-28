package dao;

import entities.EventCause;
import entities.FailureEvent;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.util.Collection;
import java.util.Date;
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
        return em.createQuery("FROM FailureEvent ")
                .getResultList();
    }

    public void addFailureEvent(FailureEvent fe){
        em.persist(fe);
    }

    //Persist all failure events in one connection to the database
    public void addFailureList(List<FailureEvent> fes){
        for(FailureEvent fe : fes){
            em.persist(fe);
        }
    }

    //User Story #4
    public Collection<?> eventCausePerIMSI(Long imsi){
        return (List<Object[]>)em.createQuery("SELECT o.eventCause.eventCauseID.causeCode, o.eventCause.eventCauseID.eventID FROM FailureEvent o WHERE o.imsi=:imsi")
                .setParameter("imsi", imsi)
                .getResultList();
    }

    //User Story #5
    public Object specificFailurePerPeriod(Date startDate, Date endDate, Long imsi){
        return em.createQuery("SELECT COUNT(o) FROM FailureEvent o WHERE o.imsi=:imsi AND o.dateTime BETWEEN ?1 AND ?2")
                .setParameter(1, startDate)
                .setParameter(2, endDate)
                .setParameter("imsi", imsi)
                .getSingleResult();
    }

    //User Story #7
    public Collection<?> IMSIPerPeriod(Date startDate, Date endDate){
        return em.createQuery("SELECT o.imsi FROM FailureEvent o WHERE o.dateTime BETWEEN ?1 AND ?2")
                .setParameter(1, startDate)
                .setParameter(2, endDate)
                .getResultList();
    }

    //User Story #8
    public Object failureCountPerModel(Date startDate, Date endDate, String model){
        return em.createQuery("SELECT COUNT(o) FROM FailureEvent o WHERE o.userEventType.model=:model AND o.dateTime BETWEEN ?1 AND ?2")
                .setParameter("model", model)
                .setParameter(1, startDate)
                .setParameter(2, endDate)
                .getSingleResult();
    }

    //User Story #9
    public Collection<?> callDataPerPeriod(Date startDate, Date endDate){
        return em.createQuery("SELECT o.imsi ,COUNT(o), SUM(o.duration) FROM FailureEvent o WHERE o.dateTime BETWEEN ?1 AND ?2 GROUP BY o.imsi")
                .setParameter(1, startDate)
                .setParameter(2, endDate)
                .getResultList();
    }

    /*//User Story #10
    public Collection<?> uniqueFailuresPerModel(String phoneModel){
        return (List<Object[]>)em.createQuery("SELECT COUNT(o), DISTINCT(o.eventCause.eventCauseID) FROM FailureEvent o WHERE o.userEventType.model IN (SELECT DISTINCT(a.eventCause.eventCauseID) FROM FailureEvent a WHERE a.userEventType.model=:phoneModel)")
                .setParameter("phoneModel", phoneModel)
                .getResultList();
    }*/

}
