package service.data;

import dao.DataDAOLocal;
import dao.FailureEventDAOLocal;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by david on 27/03/2017.
 */

@Local
@Stateless
public class DataServiceEJB implements DataServiceEJBLocal {

    @Inject
    private FailureEventDAOLocal failureEventBean;
    @Inject
    private DataDAOLocal dataImportBean;

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Collection<?> allFailureEvents(){
        return failureEventBean.getAllFailureEvents();
    }

    public Collection<?> dataImportLogs(){
        return dataImportBean.dataImportLogs();
    }
    
    public Collection<?> getAllUniqueUETypes(){
    	return failureEventBean.getAllUniqueUETypes();
    }
    
    public Collection<?> getAllUniqueIMSIs() {
		return failureEventBean.getAllUniqueIMSIs();
    }
    
    public Collection<?> getAllUniqueIMSIsV2(Long imsi) {
		return failureEventBean.getAllUniqueIMSIsV2(imsi);
    }

    //User Story #4
    public Collection<?> eventCausePerIMSI(Long imsi){
        List<Object[]> eves = null;
        try{
            eves = (List<Object[]>)failureEventBean.eventCausePerIMSI(imsi);
            for(Object[] os : eves){
                System.out.println(os[0] + ":" + os[1]);
            }
        }catch (Exception e){
            System.out.println("ERROR RETRIEVING EVENT CAUSES");
        }
        return eves;
    }

    //User Story #5
    public Object specificFailurePerPeriod(String startDate, String endDate, Long imsi){
        return failureEventBean.specificFailurePerPeriod(parseDate(startDate), parseDate(endDate), imsi);
    }

    //User Story #6
    public Collection<?> getFailEventsUsingImsiGroupedByCauseCode(Long imsi) {
        return failureEventBean.getFailEventsUsingImsiGroupedByCauseCode(imsi);
    }

    //User Story #7
    public Collection<?> IMSIPerPeriod(String startDate, String endDate){
        return failureEventBean.IMSIPerPeriod(parseDate(startDate), parseDate(endDate));
    }

    //User Story #8
    public Object failureCountPerModel(String startDate, String endDate, String phoneModel){
        return failureEventBean.failureCountPerModel(parseDate(startDate), parseDate(endDate), phoneModel);
    }

    //User Story #9
    public Collection<?> callDataPerPeriod(String startDate, String endDate){
        return failureEventBean.callDataPerPeriod(parseDate(startDate), parseDate(endDate));
    }

    //User Story #10
    public Collection<?> getFailEventAndCauseCodeByUEType(Integer ueType){
        return failureEventBean.getFailEventAndCauseCodeByUEType(ueType);
    }

    //User Story #12
    public Collection<?> getTopTenIMSIsForFailureClassPerPeriod(String startDate, String endDate){
        return failureEventBean.getTopTenIMSIsForFailureClassPerPeriod(parseDate(startDate), parseDate(endDate));
    }

    //User Story #13
    public Collection<?> getTopTenNodeFailuresPercentage(){
        return failureEventBean.getTopTenNodeFailuresPercentage();
    }

    //User Story #14
    public Collection<?> getIMSisForFailureClass(Integer failureClass) {
        return failureEventBean.getIMSisForFailureClass(failureClass);
    }

    public Date parseDate(String date){
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
