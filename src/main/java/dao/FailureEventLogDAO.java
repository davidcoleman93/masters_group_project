package dao;

import entities.FailureEventLog;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
