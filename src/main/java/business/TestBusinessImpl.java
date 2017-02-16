package business;

import dao.TestDAOLocal;
import entities.EventCause;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Collection;
import java.util.List;

/**
 * Created by C06590861 on 15/02/2017.
 */

@Local
@Stateless
public class TestBusinessImpl implements TestBusinessLocal {

    @Inject
    private TestDAOLocal daoBean;

    @Resource
    private SessionContext session;

    public void addRecord(Object o){
    }

    public Collection<?> getAll(){

        return daoBean.getAll();

    }

}
