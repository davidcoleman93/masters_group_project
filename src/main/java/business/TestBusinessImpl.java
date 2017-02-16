package business;

import dao.TestDAOLocal;
import entities.test_entities.TableUn;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
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

    public void addRecord(){
    }

    public List<TableUn> getAll(){

        return daoBean.getAll();

    }


}
