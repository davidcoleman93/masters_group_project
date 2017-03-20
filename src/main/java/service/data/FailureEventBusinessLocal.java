package service.data;

import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by david on 19/02/2017.
 */

@Local
public interface FailureEventBusinessLocal {
    Collection<?> getEventCausePerIMSI(Long imsi);
    void postCSV(String fileName);
}
