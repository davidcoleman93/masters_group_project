package service.data;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import dao.*;
import entities.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import javax.ejb.*;
import javax.inject.Inject;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by C06590861 on 16/02/2017.
 */

@Local
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class FailureEventBusinessImpl implements FailureEventBusinessLocal {

    @Inject
    private FailureEventDAOLocal failureEventBean;

    @Inject
    private DataDAOLocal dataBean;

    @Inject
    private EventCauseDAOLocal eventCauseBean;

    @Inject
    private FailureClassDAOLocal failureClassBean;

    @Inject
    private MarketOperatorDAOLocal marketOperatorBean;

    @Inject
    private UserEventTypeDAOLocal ueTypeBean;

    @Inject
    private FailureEventLogDAOLocal feLogBean;

    public Collection<?> getEventCausePerIMSI(Long imsi){
        List<Object[]> eves = null;
        try{
            eves = (List<Object[]>)failureEventBean.getEventCausePerIMSI(imsi);
            for(Object[] os : eves){
                System.out.println(os[0] + ":" + os[1]);
            }
        }catch (Exception e){
            System.out.println("ERROR RETRIEVING EVENT CAUSES");
        }
        return eves;
    }

    public void postCSV(String fileName) {

        File temp = null;
        LineIterator lineIterator = null;
        Long numErrors = 0L;
        Long numImports = 0L;
        int lineNum = 0;

        Multimap<Integer, Integer> eventMap = ArrayListMultimap.create();
        Multimap<Integer, Integer> marketMap = ArrayListMultimap.create();
        HashSet<Integer> failureMap = null;
        HashSet<Integer> ueMap = null;

        try{
            eventMap = eventCauseBean.getEventCauseMap();
        }catch (Exception e){
            System.out.println("ERROR IN PARSING EVENT CAUSE TO MULTIMAP");
        }

        try{
            marketMap = marketOperatorBean.getMarketOpMap();
        }catch (Exception e){
            System.out.println("ERROR IN PARSING MARKET TO MULTIMAP");
        }

        try{
            ueMap = ueTypeBean.getUserEventSet();
        }catch (Exception e){
            System.out.println("ERROR IN PARSING UE TYPE TO MULTIMAP");
        }

        try{
            failureMap = failureClassBean.getFailureClassSet();
        }catch (Exception e){
            System.out.println("ERROR IN PARSING FAILURE CLASS TO MULTIMAP");
        }

        try{
            temp = new File(fileName);
            lineIterator = FileUtils.lineIterator(temp, "UTF-8");
        }catch(Exception ioe){
        }

        try{
            System.out.println("STARTED");
            while(lineIterator.hasNext()){
                String line = lineIterator.nextLine();
                if(lineNum == 0){
                    lineNum++;
                }else {
                    lineNum++;

                    boolean error = false;

                    String[] fEvents = line.split(",");

                    Date dateTime = null;
                    Integer eventID = null;
                    Integer failureClass = null;
                    Integer ueType = null;
                    Integer market = null;
                    Integer operator = null;
                    Integer cellID = null;
                    Integer duration = null;
                    Integer causeCode = null;
                    String neVersion = null;
                    Long imsi = null;

                    try{
                        String startDateString = fEvents[0];
                        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                        if (startDateString.contains("/")) {
                            DateFormat srcDf = new SimpleDateFormat("dd/MM/yyy HH:mm");
                            Date retrievedDate = srcDf.parse(startDateString);
                            startDateString = df.format(retrievedDate);
                        }
                        dateTime = df.parse(startDateString);
                    }catch(Exception pe){
                        if(!error) error = true;
                    }

                    try{
                        eventID = Integer.parseInt(fEvents[1]);
                    }catch (Exception pe){
                        if(!error) error = true;
                    }

                    try{
                        failureClass = Integer.parseInt(fEvents[2]);
                    }catch(Exception e){
                        if(!error) error = true;
                    }

                    try{
                        ueType = Integer.parseInt(fEvents[3]);
                    }catch(Exception e){
                        if(!error) error = true;
                    }

                    try{
                        market = Integer.parseInt(fEvents[4]);
                    }catch(Exception e){
                        if(!error) error = true;
                    }

                    try{
                        operator = Integer.parseInt(fEvents[5]);
                    }catch(Exception e){
                        if(!error) error = true;
                    }

                    try{
                        cellID = Integer.parseInt(fEvents[6]);
                    }catch(Exception e){
                        if(!error) error = true;
                    }

                    try{
                        duration = Integer.parseInt(fEvents[7]);
                    }catch(Exception e){
                        if(!error) error = true;
                    }

                    try{
                        causeCode = Integer.parseInt(fEvents[8]);
                    }catch(Exception e){
                        if(!error) error = true;
                    }

                    try{
                        neVersion = fEvents[9];
                    }catch(Exception e){
                        if(!error) error = true;
                    }

                    try{
                        imsi = Long.parseLong(fEvents[10]);
                    }catch(Exception e){
                        if(!error) error = true;
                    }

                    if(!error){
                        if(eventMap.containsEntry(causeCode, eventID) &&
                                failureMap.contains(failureClass) &&
                                marketMap.containsEntry(market, operator) &&
                                ueMap.contains(ueType)){
                            failureEventBean.addFailureEvent(new FailureEvent(
                                    dateTime,
                                    new EventCause(new EventCauseID(causeCode, eventID)),
                                    new FailureClass(failureClass),
                                    new UserEventType(ueType),
                                    new MarketOperator(new MarketOperatorID(market, operator)),
                                    cellID,
                                    duration,
                                    neVersion,
                                    imsi));
                            numImports++;
                        }else{
                            //This is duplicated BELOW....need to look at this!!!
                            feLogBean.addLogRecord(
                                    new FailureEventLog(
                                            dateTime,
                                            eventID,
                                            failureClass,
                                            ueType,
                                            market,
                                            operator,
                                            cellID,
                                            duration,
                                            causeCode,
                                            neVersion,
                                            imsi)
                            );
                            numErrors++;
                        }
                    }else{
                        //Add erroneous record to the log table
                        feLogBean.addLogRecord(
                                new FailureEventLog(
                                        dateTime,
                                        eventID,
                                        failureClass,
                                        ueType,
                                        market,
                                        operator,
                                        cellID,
                                        duration,
                                        causeCode,
                                        neVersion,
                                        imsi)
                        );
                        numErrors++;
                    }
                }
            }
        }finally {
            LineIterator.closeQuietly(lineIterator);
        }
        System.out.println("COMPLETED");

        if(numErrors == (long)(lineNum)){
            dataBean.addDataImport(new DataImportLog(new Date(), false, numImports, numErrors));
        }else{
            dataBean.addDataImport(new DataImportLog(new Date(), true, numImports, numErrors));
        }

    }
}
