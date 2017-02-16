package dao;

import entities.test_entities.TableUn;

import javax.ejb.Local;
import java.util.Collection;
import java.util.List;

/**
 * Created by C06590861 on 15/02/2017.
 */

@Local
public interface TestDAOLocal {
    void addRecord(Object o);
    Collection<?> getAll();
}
