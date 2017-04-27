package service.data;

import entities.EventCause;

import javax.ejb.Local;
import java.util.Collection;

/**
 * Created by david on 28/03/2017.
 */
@Local
public interface EventCauseValidationEJBLocal {
    void updateEventCause(String fileName);
    Collection<?> allEventCauses();
}
