package dao;

import javax.ejb.Local;
import java.util.Collection;

/**
 * Created by C06590861 on 15/02/2017.
 */

@Local
public interface TestDAOLocal {
    void addRecord(Object o);
    Collection<?> getAll();
}
