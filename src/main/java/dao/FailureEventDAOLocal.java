package dao;

import javax.ejb.Local;

import entities.FailureEvent;

import java.util.Collection;

/**
 * Created by david on 19/02/2017.
 */

@Local
public interface FailureEventDAOLocal {
    Collection<?> getAllFailureEvents();

	public void addFailEvent(FailureEvent fEvent);
}
