package dao;

import entities.UserEventType;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

/**
 * Created by david on 19/02/2017.
 */

@Local
@Stateless
public class UserEventTypeDAOImpl implements UserEventTypeDAOLocal {

    @PersistenceContext
    private EntityManager em;

    public Collection<?> getAllUserEventTypes(){
        return (List<UserEventType>)em.createQuery("FROM UserEventType ").getResultList();
    }

}
