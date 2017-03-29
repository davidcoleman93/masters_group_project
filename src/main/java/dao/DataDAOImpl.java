package dao;

import entities.DataImportLog;
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

    public void addDataImport(DataImportLog log){
        em.persist(log);
    }

}
