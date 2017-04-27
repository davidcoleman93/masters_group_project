package service.data;

import javax.ejb.Local;

/**
 * Created by david on 19/02/2017.
 */

@Local
public interface FailureEventBusinessLocal {
    void postCSV(String FILE_PATH, String DIR_PATH);
}
