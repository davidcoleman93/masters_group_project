package service.data;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import dao.*;
import entities.*;
import org.apache.commons.io.*;

import javax.ejb.*;
import javax.inject.Inject;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
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

    private String DIR_PATH;

    public void postCSV(String fileName, String DIR_PATH) {
        this.DIR_PATH = DIR_PATH;
        /*
            Objects for scanning CSV file
         */
        File temp = null;
        LineIterator lineIterator = null;
        /*
            Failure event variables
         */
        Date dateTime;
        Integer eventID, failureClass, ueType, market, operator, cellID, duration, causeCode;
        String neVersion;
        Long imsi;

        String[] fEvents;

        //DATA STRUCTURES TO STORE FailureEvents & Logs
        List<FailureEvent> failureEventList = new ArrayList<FailureEvent>();
        List<FailureEventLog> failureLogList = new ArrayList<FailureEventLog>();

        //DATE format objects
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat srcDf = new SimpleDateFormat("MM/dd/yy hh:mm");

        /*
            Data Structures to store foreign key tables
         */
        Multimap<Integer, Integer   > eventMap = ArrayListMultimap.create();
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

        /*
            Meta Data variables
         */
        Long numErrors = 0L;
        Long numImports = 0L;
        int lineNum = 0;

        /*
            Error boolean(trigger)
         */
        boolean error;

        try{
            System.out.println("STARTED");
            while(lineIterator.hasNext()){
                /*
                    Split the next line into the String array using the delimiter ','
                */
                fEvents = lineIterator.nextLine().split(",");
                if(lineNum == 0){
                    lineNum++;
                }else if(lineNum == 1){
                    /*
                        Reset Failure event/error variables
                     */
                    error = false;

                    dateTime = null;
                    eventID = null;
                    failureClass = null;
                    ueType = null;
                    market = null;
                    operator = null;
                    cellID = null;
                    duration = null;
                    causeCode = null;
                    neVersion = null;
                    imsi = null;

                    /*
                        Try parse the values to each corresponding data type
                     */
                    try{
                        String startDateString = fEvents[0];
                        //System.out.println(startDateString);
                        if (startDateString.contains("/")) {
                            Date retrievedDate = srcDf.parse(startDateString);
                            //System.out.println(retrievedDate);
                            startDateString = df.format(retrievedDate);
                            //System.out.println(startDateString);
                        }
                        dateTime = df.parse(startDateString);
                        //System.out.println(dateTime);
                    }catch (Exception pe){
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
                    /*
                        As long as there were no errors in parsing the data, process.
                     */
                    if(!error) {
                        /*
                            Check relationships
                         */
                        if (eventMap.containsEntry(causeCode, eventID)
                                && failureMap.contains(failureClass)
                                && marketMap.containsEntry(market, operator)
                                && ueMap.contains(ueType)) {
                            /*
                                Adding the Failure Events to a List sped up data import of 30k records from 3 minutes to 14 seconds.
                             */
                            failureEventList.add(
                                    new FailureEvent(
                                        dateTime,
                                        new EventCause(new EventCauseID(causeCode, eventID)),
                                        new FailureClass(failureClass),
                                        new UserEventType(ueType),
                                        new MarketOperator(new MarketOperatorID(market, operator)),
                                        cellID,
                                        duration,
                                        neVersion,
                                        imsi
                                    )
                            );
                            numImports++;
                        }else{
                            error = true;
                        }
                    }
                    /*
                        Process erroneous records.
                     */
                    if(error){
                        failureLogList.add(new FailureEventLog(
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
                            imsi));
                        numErrors++;
                    }
                }
            }
        }finally {
            LineIterator.closeQuietly(lineIterator);
        }
        /*
            Send Failure Event and Failure Logs to be persisted to the database
         */
        synchronized (this){
            failureEventBean.addFailureList(failureEventList);
        }
        synchronized (this){
            feLogBean.addFailureLogList(failureLogList);
        }

        System.out.println("COMPLETED");
        /*
            Insert the meta data for this import to the database.
            (If EVERY record in the file was erroneous then it was not a successful import)
         */
        if(numErrors == ((long)(lineNum) - 1)){
            dataBean.addDataImport(new DataImportLog(new Date(), false, numImports, numErrors));
        }else{
            dataBean.addDataImport(new DataImportLog(new Date(), true, numImports, numErrors));
        }
        synchronized (this){
            deleteFiles();
        }
    }

    private void deleteFiles() {
        File fin = new File(DIR_PATH);
        for (File file : fin.listFiles()) {
            try {
                FileDeleteStrategy.FORCE.delete(file);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
