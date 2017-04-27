package dao;

import entities.EventCause;
import entities.FailureClass;
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
    
    public Collection<?> getAllUniqueUETypes()
    {
    	return em.createQuery("SELECT DISTINCT userEventType.tac FROM FailureEvent")
    			.getResultList();
    }
    
    public Collection<?> getAllUniqueIMSIs()
    {
    	return em.createQuery("SELECT DISTINCT imsi FROM FailureEvent")
    			.getResultList();
	}

    public Collection<?> getAllUniquePhoneModels()
    {
        return em.createQuery("SELECT DISTINCT model FROM UserEventType ")
                .getResultList();
    }

    public Collection<?> getAllUniqueFailureClasses() {
        return (List<FailureClass>) em.createQuery("SELECT DISTINCT fc FROM FailureClass fc ")
                .getResultList();
    }
    
    public Collection<?> getAllUniqueIMSIsV2(Long imsi)
    {
    	return em.createQuery("SELECT DISTINCT imsi FROM FailureEvent fe WHERE fe.imsi LIKE :imsi")
    			.setParameter("imsi", "%" + imsi + "%")
    			.getResultList();
	}
    
    //Persist all failure events in one connection to the database
    public void addFailureList(List<FailureEvent> fes){
        for(FailureEvent fe : fes){
            em.persist(fe);
        }
    }

    //User Story #4
    public Collection<?> eventCausePerIMSI(Long imsi){
        return (List<EventCause>)em.createQuery("SELECT o.eventCause FROM FailureEvent o WHERE o.imsi=:imsi")
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
        return (List<Object[]>)em.createQuery("SELECT fe.eventCause, count(fe) FROM FailureEvent fe WHERE fe.imsi=:imsi GROUP BY fe.eventCause.eventCauseID.causeCode")
                .setParameter("imsi",imsi)
                .getResultList();
    }

    //User Story #7
    public Collection<?> IMSIPerPeriod(Date startDate, Date endDate){
        return (List<FailureEvent>) em.createQuery("SELECT o FROM FailureEvent o WHERE o.dateTime BETWEEN ?1 AND ?2")
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
        return (List<Object[]>)em.createQuery("SELECT DISTINCT o.imsi ,COUNT(o), SUM(o.duration) FROM FailureEvent o WHERE o.dateTime BETWEEN ?1 AND ?2 GROUP BY o.imsi")
                .setParameter(1, startDate)
                .setParameter(2, endDate)
                .getResultList();
    }

    //User Story #10
    public Collection<?> getFailEventAndCauseCodeByUEType(String model){
        return (List<Object[]>)em.createQuery("SELECT fe.eventCause, count(fe) FROM FailureEvent fe WHERE fe.userEventType.model=:model GROUP BY fe.eventCause")
                .setParameter("model",model)
                .getResultList();
    }

    //User Story #11
    public Collection<?> topTenCallFailurePerPeriod(Date startDate, Date endDate) {
        return (List<Object[]>) em.createQuery("SELECT o.marketOperator, o.cellID, count(o) as total FROM FailureEvent o WHERE o.dateTime BETWEEN ?1 AND ?2 GROUP BY o.marketOperator, o.cellID ORDER BY total DESC ")
                .setParameter(1, startDate)
                .setParameter(2, endDate)
                .setMaxResults(10)
                .getResultList();
    }

    //User Story #12
    public Collection<?> getTopTenIMSIsForFailureClassPerPeriod(Date startDate, Date endDate){
        System.out.println("HERE");
        return (List<Object[]>) em.createQuery("SELECT o.imsi, COUNT(o) AS countIMSI FROM FailureEvent o WHERE o.dateTime BETWEEN ?1 AND ?2 GROUP BY o.imsi ORDER BY countIMSI DESC")
                .setParameter(1, startDate)
                .setParameter(2, endDate)
                .setMaxResults(10)
                .getResultList();
    }

    //User Story #13
    public Collection<?> getTopTenNodeFailuresPercentage(){
        Long totalNum = (Long)em.createQuery("select count(o) from FailureEvent o").getSingleResult();

        return (List<Object[]>) em.createQuery("SELECT o.marketOperator, o.cellID, count(o) as numFailures, (count(o)/:totalNum)*100 from FailureEvent o group by o.marketOperator, o.cellID order by numFailures DESC")
                .setParameter("totalNum", totalNum)
                .setMaxResults(10)
                .getResultList();
    }

    //User Story #14
    public Collection<?> getIMSisForFailureClass(Integer failureClass){
        return (List<FailureEvent>)em.createQuery("SELECT DISTINCT fe FROM FailureEvent fe WHERE fe.failureClass.failureClass=:failureClass")
                .setParameter("failureClass",failureClass)
                .getResultList();
    }

}
