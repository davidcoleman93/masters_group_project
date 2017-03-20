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

    public Collection<?> getEventCausePerIMSI(Long imsi){
        return (List<Object[]>)em.createQuery("SELECT o.eventCause.eventCauseID.causeCode, o.eventCause.eventCauseID.eventID FROM FailureEvent o WHERE o.imsi=:imsi")
                .setParameter("imsi", imsi)
                .getResultList();
    }

    public void addFailureEvent(FailureEvent fe){
        em.persist(fe);
    }

    public void addFailureList(List<FailureEvent> fes){
        for(FailureEvent fe : fes){
            em.persist(fe);
        }
    }

}
