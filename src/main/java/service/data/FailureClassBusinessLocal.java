package service.data;

import javax.ejb.Local;

/**
 * Created by david on 20/02/2017.
 */

@Local
public interface FailureClassBusinessLocal {
    void updateFailureClasses(String fileName);
}
