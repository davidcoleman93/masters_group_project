package dao;

import entities.FailureClass;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

/**
 * Created by C06590861 on 15/02/2017.
 */

@Local
@Stateless
public class FailureClassDAOImpl implements FailureClassDAOLocal {

    @PersistenceContext
    private EntityManager em;

    public HashSet<Integer> getFailureClassSet(){
        List<Integer> temp = (List<Integer>)
                em.createQuery("SELECT o.failureClass FROM FailureClass o").getResultList();

        HashSet<Integer> set = new HashSet<Integer>();
        for(Integer t : temp) {
            set.add(t);
        }

        return set;
    }

    public void addFailureClass(FailureClass failureClass){
        em.persist(failureClass);
    }

    public Collection<?> allFailureClasses(){
        return (List<FailureClass>) em.createQuery( "FROM FailureClass " ).getResultList();
    }
}
