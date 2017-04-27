package dao;

import entities.UserEventType;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Created by david on 19/02/2017.
 */

@Local
@Stateless
public class UserEventTypeDAOImpl implements UserEventTypeDAOLocal {

    @PersistenceContext
    private EntityManager em;

    public HashSet<Integer> getUserEventSet(){
        List<Integer> temp = (List<Integer>)
                em.createQuery("SELECT o.tac FROM UserEventType o").getResultList();

        HashSet<Integer> set = new HashSet<Integer>();
        for(Integer t : temp) {
            set.add(t);
        }

        return set;
    }

    public void addUserEventType(UserEventType userEventType){
        em.persist(userEventType);
    }

    public Collection<?> allUserEventTypes(){
        return (List<UserEventType>) em.createQuery("FROM UserEventType ").getResultList();
    }
}
