package service.data;

import javax.ejb.Local;
import java.util.Collection;

/**
 * Created by david on 20/02/2017.
 */

@Local
public interface FailureClassBusinessLocal {
    void updateFailureClasses(String fileName);
    Collection<?> allFailureClasses();
}
