package service;

import dao.UserEventTypeDAOLocal;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by david on 19/02/2017.
 */

@Local
@Stateless
public class UserEventTypeBusinessImpl implements UserEventTypeBusinessLocal {

    @Inject
    private UserEventTypeDAOLocal daoBean;

    @Resource
    private SessionContext session;

    public Collection<?> getAllUserEventTypes(){
        return daoBean.getAllUserEventTypes();
    }

}
