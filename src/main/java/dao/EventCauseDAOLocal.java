package dao;

import entities.EventCause;
import entities.EventCauseID;

import javax.ejb.Local;
import java.util.Collection;

/**
 * Created by david on 19/02/2017.
 */

@Local
public interface EventCauseDAOLocal {
    Collection<?> getAllEventCauses();
    EventCause getEventCause(EventCauseID eventCauseID);
}
