package service;

import dao.FailureEventDAOLocal;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by C06590861 on 16/02/2017.
 */

@Local
@Stateless
public class FailureEventBusinessImpl implements FailureEventBusinessLocal {

    @Inject
    private FailureEventDAOLocal daoBean;

    @Resource
    private SessionContext session;

    public Collection<?> getAllFailureEvents(){

        return daoBean.getAllFailureEvents();

    }

}
