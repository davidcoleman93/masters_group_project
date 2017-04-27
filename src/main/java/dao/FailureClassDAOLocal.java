package dao;

import entities.FailureClass;

import javax.ejb.Local;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by david on 19/02/2017.
 */

@Local
public interface FailureClassDAOLocal {
    HashSet<Integer> getFailureClassSet();
    void addFailureClass(FailureClass failureClass);
    Collection<?> allFailureClasses();
}
