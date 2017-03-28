package dao;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.sun.net.httpserver.Authenticator;
import entities.EventCause;
import entities.EventCauseID;
import entities.FailureClass;
import sun.awt.image.ImageWatched;

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

    public void addFailureClass(FailureClass failureClass){
        em.persist(failureClass);
    }

    public HashSet<Integer> getFailureClassSet(){
        List<Integer> temp = (List<Integer>)
                em.createQuery("SELECT o.failureClass FROM FailureClass o").getResultList();

        HashSet<Integer> set = new HashSet<Integer>();
        for(Integer t : temp) {
            set.add(t);
        }

        return set;
    }

}
