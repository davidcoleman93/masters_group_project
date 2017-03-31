package dao;

import entities.FailureEvent;
import entities.FailureEventLog;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by C06590861 on 15/03/2017.
 */

@Local
@Stateless
public class FailureEventLogDAO implements FailureEventLogDAOLocal {

    @PersistenceContext
    private EntityManager em;

    public void addLogRecord(FailureEventLog feLog){
        em.persist(feLog);
    }

    public void addFailureLogList(List<FailureEventLog> fes){
        //int i = 0;
        for (FailureEventLog fe : fes){
            //System.out.println(++i);
            em.persist(fe);
        }
    }

}
