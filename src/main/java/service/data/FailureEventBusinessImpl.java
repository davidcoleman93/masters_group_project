package service.data;

import dao.*;
import entities.*;

import javax.ejb.*;
import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

    public Collection<?> getAllFailureEvents(){

    	List<Object[]> objsFail = null;

        try{
            objsFail = (List<Object[]>)failureEventBean.getAllFailureEvents();
        }catch(Exception e){
            System.out.println("THERE IS A PROBLEM WITH DAO");
        }

        return objsFail;

    }

    public synchronized void postCSV(String fileName) {

        //List<FailureEvent> errors = new ArrayList<FailureEvent>();

        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ",";
        Long numErrors = 0L;
        Long numImports = 0L;
        int lineNum = 0;

        try {
            br = new BufferedReader(new FileReader(fileName));

            System.out.println("STARTED");
            while ((line = br.readLine()) != null) {

                if(lineNum == 0){
                    lineNum++;
                }else {
                    lineNum++;

                    boolean error = false;

                    String[] fEvents = line.split(csvSplitBy);

                    Date dateTime = null;
                    Integer eventID = 0;
                    Integer failureClass = 0;
                    Integer ueType = 0;
                    Integer market = 0;
                    Integer operator = 0;
                    Integer cellID = 0;
                    Integer duration = 0;
                    Integer causeCode = 0;
                    String neVersion = "";
                    Long imsi = 0L;

                    try{
                        String startDateString = fEvents[0];
                        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        if (startDateString.contains("/")) {
                            DateFormat srcDf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                            Date retrivedDate = srcDf.parse(startDateString);
                            startDateString = df.format(retrivedDate);
                        }
                        dateTime = df.parse(startDateString);
                        try{
                            eventID = Integer.parseInt(fEvents[1]);
                            try{
                                failureClass = Integer.parseInt(fEvents[2]);
                                try{
                                    ueType = Integer.parseInt(fEvents[3]);
                                    try{
                                        market = Integer.parseInt(fEvents[4]);
                                        try{
                                            operator = Integer.parseInt(fEvents[5]);
                                            try{
                                                cellID = Integer.parseInt(fEvents[6]);
                                                try{
                                                    duration = Integer.parseInt(fEvents[7]);
                                                    try{
                                                        causeCode = Integer.parseInt(fEvents[8]);
                                                        try{
                                                            neVersion = fEvents[9];
                                                            try{
                                                                imsi = Long.parseLong(fEvents[10]);
                                                            }catch(Exception e){
                                                                error = true;
                                                            }
                                                        }catch(Exception e){
                                                            error = true;
                                                        }
                                                    }catch(Exception e){
                                                        error = true;
                                                    }
                                                }catch(Exception e){
                                                    error = true;
                                                }
                                            }catch(Exception e){
                                                error = true;
                                            }
                                        }catch(Exception e){
                                            error = true;
                                        }
                                    }catch(Exception e){
                                        error = true;
                                    }
                                }catch(Exception e){
                                    error = true;
                                }
                            }catch(Exception e){
                                error = true;
                            }
                        }catch (Exception pe){
                            error = true;
                        }
                    }catch(Exception pe){
                        error = true;
                    }

                    if(!error){
                        if(!eventCauseBean.checkEventCause(new EventCauseID(causeCode, eventID))){
                            if(!failureClassBean.checkFailureClass(failureClass)){
                                if(!marketOperatorBean.checkMarketOperator(new MarketOperatorID(market, operator))){
                                    if(!ueTypeBean.checkUserEventType(ueType)){

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
                                        //WRONG USER EVENT
                                        continue;
                                    }
                                }else{
                                    //WRONG MARKET
                                    continue;
                                }
                            }else{
                                //WRONG FAILURE CLASS
                                continue;
                            }
                        }else{
                            //WRONG EVENT CAUSE
                            continue;
                        }
                    }else{
                        numErrors++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("COMPLETE");

        if(numErrors == (long)(lineNum)){
            dataBean.addDataImport(new DataImportLog(new Date(), new Boolean(false), numImports));
        }else{
            dataBean.addDataImport(new DataImportLog(new Date(), new Boolean(true), numImports));
        }
    }
}
