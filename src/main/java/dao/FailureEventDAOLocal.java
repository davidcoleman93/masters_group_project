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
    //ALL DATA
    Collection<?> getAllFailureEvents();

    void addFailureEvent(FailureEvent fe);
    void addFailureList(List<FailureEvent> c);
    
    Collection<?> getAllUniqueUETypes();
    Collection<?> getAllUniqueIMSIs();
    Collection<?> getAllUniqueIMSIsV2(Long imsi);

    //User Story #4
    Collection<?> eventCausePerIMSI(Long imsi);
    //User Story #5
    Object specificFailurePerPeriod(Date startDate, Date endDate, Long imsi);
    //User Story #6
    Collection<?> getFailEventsUsingImsiGroupedByCauseCode(Long imsi);
    //User Story #7
    Collection<?> IMSIPerPeriod(Date startDate, Date endDate);
    //User Story #8
    Object failureCountPerModel(Date startDate, Date endDate, String phoneModel);
    //User Story #9
    Collection<?> callDataPerPeriod(Date startDate, Date endDate);
    //User Story #10
    Collection<?> getFailEventAndCauseCodeByUEType(Integer ueType);

    //User Story #14
    Collection<?> getIMSisForFailureClass(Integer failureClass);

}
