package dao;

import entities.FailureEvent;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    //User Story #6
    public Collection<?> getFailEventsUsingImsiGroupedByCauseCode(Long imsi) {
        return (List<Object[]>)em.createQuery("SELECT fe.imsi, fe.eventCause.eventCauseID.causeCode, count(fe) FROM FailureEvent fe WHERE fe.imsi=:imsi GROUP BY fe.eventCause.eventCauseID.causeCode")
                .setParameter("imsi",imsi)
                .getResultList();
        //select imsi, cause_code, count(*) as count
        //from failure_events
        //where imsi = 191911000516761
        //group by cause_code;
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

    //User Story #10
    public Collection<?> getFailEventAndCauseCodeByUEType(Integer ueType){
        return (List<Object[]>)em.createQuery("SELECT fe.userEventType.tac, fe.eventCause.eventCauseID.eventID, fe.eventCause.eventCauseID.causeCode, count(fe) FROM FailureEvent fe WHERE fe.userEventType.tac=:ueType GROUP BY fe.eventCause.eventCauseID.eventID, fe.eventCause.eventCauseID.causeCode")
                .setParameter("ueType",ueType)
                .getResultList();

        //select ue_type, event_id, cause_code, count(*) as count
        //from failure_events
        //where ue_type = 100100
        //group by event_id, cause_code;
    }

}
