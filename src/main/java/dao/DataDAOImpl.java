package dao;

import entities.FailureEvent;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

/**
 * Created by C06590861 on 23/02/2017.
 */

@Local
@Stateless
public class DataDAOImpl implements DataDAOLocal {

    @PersistenceContext
    private EntityManager em;

    public void addFailureEvent(FailureEvent fe){
        em.persist(fe);
    }

    public Collection<?> getCallFailures(){
        return (List<Object>)em.createQuery("SELECT DISTINCT(o.imsi), COUNT(o), SUM(o.duration) FROM FailureEvent o")
                .getResultList();
    }

}
