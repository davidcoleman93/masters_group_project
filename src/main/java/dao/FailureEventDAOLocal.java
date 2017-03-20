package dao;

import entities.FailureEvent;

import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.persistence.Column;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by david on 19/02/2017.
 */

@Local
public interface FailureEventDAOLocal {
    Collection<?> getEventCausePerIMSI(Long imsi);
    void addFailureEvent(FailureEvent fe);
    void addFailureList(List<FailureEvent> c);
}
