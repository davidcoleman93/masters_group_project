package dao;

import entities.UserEventType;

import javax.ejb.Local;
import java.util.Collection;

/**
 * Created by david on 19/02/2017.
 */

@Local
public interface UserEventTypeDAOLocal {
    Collection<?> getAllUserEventTypes();
    UserEventType getUserEventType(int tac);
}
