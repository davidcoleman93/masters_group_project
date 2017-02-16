package dao;

import entities.test_entities.TableUn;

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
public class TestDAOImpl implements TestDAOLocal {

    @PersistenceContext
    private EntityManager em;

    public void addRecord(){
        //em.persist();
    }

    public Collection<?> getAll(){
        return em.createQuery("FROM TableUn").getResultList();
    }

}
