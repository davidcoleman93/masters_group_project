package dao;

import entities.FailureClass;

import javax.ejb.Local;
import java.util.Collection;

/**
 * Created by david on 19/02/2017.
 */

@Local
public interface FailureClassDAOLocal {
	Collection<?> getAllFailureClasses();

	FailureClass getFailureClass(Integer failureClass);

	boolean checkFailureClass(Integer failureClass);
}
