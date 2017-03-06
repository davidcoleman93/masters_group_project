package service;

import javax.ejb.Local;

import entities.FailureEvent;

import java.util.Collection;

/**
 * Created by david on 19/02/2017.
 */

@Local
public interface FailureEventBusinessLocal {
	Collection<?> getAllFailureEvents();

	public void postCSV();

	public void addFailEvent(FailureEvent fEvent);
}
