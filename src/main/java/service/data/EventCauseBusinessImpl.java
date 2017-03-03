package service.data;

import dao.EventCauseDAOLocal;

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
public class EventCauseBusinessImpl implements EventCauseBusinessLocal {

    @Inject
    private EventCauseDAOLocal daoBean;

    @Resource
    private SessionContext session;

    public Collection<?> getAllEventCauses(){

        return daoBean.getAllEventCauses();

    }

}
