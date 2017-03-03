package dao;

import entities.FailureEvent;

import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import java.util.Collection;

/**
 * Created by david on 19/02/2017.
 */

@Local
public interface FailureEventDAOLocal {
    Collection<?> getAllFailureEvents();
    void addFailureEvent(FailureEvent fe);
}
