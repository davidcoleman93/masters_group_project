package service.data;

import javax.ejb.Local;

/**
 * Created by david on 28/03/2017.
 */
@Local
public interface UserEventValidationEJBLocal {
    void updateUserEvent(String fileName);
}
