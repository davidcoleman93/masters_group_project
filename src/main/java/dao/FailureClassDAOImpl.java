package dao;

import entities.FailureClass;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

/**
 * Created by C06590861 on 15/02/2017.
 */

@Local
@Stateless
public class FailureClassDAOImpl implements FailureClassDAOLocal {

    @PersistenceContext
    private EntityManager em;

    public Collection<?> getAllFailureClasses(){
        return (List<FailureClass>)em.createQuery("FROM FailureClass ").getResultList();
    }

}
