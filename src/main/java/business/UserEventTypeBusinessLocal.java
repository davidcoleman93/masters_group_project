package business;

import javax.ejb.Local;
import java.util.Collection;

/**
 * Created by david on 20/02/2017.
 */

@Local
public interface UserEventTypeBusinessLocal {
    Collection<?> getAllUserEventTypes();
}
