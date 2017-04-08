package service.data;

import java.util.Collection;
import java.util.Date;

/**
 * Created by david on 27/03/2017.
 */
public interface DataServiceEJBLocal {
    //ALL DATA
    Collection<?> allFailureEvents();
    Collection<?> dataImportLogs();
    
    Collection<?> getAllUniqueUETypes();

    //User Story #4
    Collection<?> eventCausePerIMSI(Long imsi);
    //User Story #5
    Object specificFailurePerPeriod(String startDate, String endDate, Long imsi);
    //User Story #6
    Collection<?> getFailEventsUsingImsiGroupedByCauseCode(Long imsi);
    //User Story #7
    Collection<?> IMSIPerPeriod(String startDate, String endDate);
    //User Story #8
    Object failureCountPerModel(String startDate, String endDate, String phoneModel);
    //User Story #9
    Collection<?> callDataPerPeriod(String startDate, String endDate);
    //User Story #10
    Collection<?> getFailEventAndCauseCodeByUEType(Integer ueType);
}
