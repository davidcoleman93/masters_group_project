package service.data;

import javax.ejb.Local;

/**
 * Created by david on 27/03/2017.
 */

@Local
public interface CSVMediatorLocal {
    void scanFirstLineCSV(String fileName, String DIR_PATH);
}
