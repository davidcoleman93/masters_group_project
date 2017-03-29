package service.data;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.io.File;

/**
 * Created by david on 27/03/2017.
 */

@Local
@Stateless
public class CSVMediator implements CSVMediatorLocal {

    @EJB
    private FailureEventBusinessLocal failureEJB;
    /*@EJB
    private FailureClassBusinessLocal failureClassEJB;*/
    /*@EJB
    private EventCauseValidationLocal eventCauseEJB;*/
    /*@EJB
    private UserEventValidationLocal userEventEJB;*/
    /*@EJB
    private MarketOperatorValidationLocal marketOperatorEJB;*/

    public void scanFirstLineCSV(String fileName){
        /*
            Objects for scanning CSV file
         */
        File temp = null;
        LineIterator lineIterator = null;
        try{
            temp = new File(fileName);
            lineIterator = FileUtils.lineIterator(temp, "UTF-8");
        }catch(Exception ioe){}

        String[] fEvents;

        try{
            int lineNum = 0;
            while(lineIterator.hasNext()){
                if(lineNum == 0){
                    fEvents = lineIterator.nextLine().split(",");

                    if(fEvents[0].equals("Cause Code")){
                        synchronized (this){
                            //eventCauseEJB.updateEventCauses(fileName);
                        }
                        continue;
                    }
                    if(fEvents[0].equals("Failure Class")){
                        synchronized (this){
                            //failureClassEJB.updateFailureClasses(fileName);
                        }
                        continue;
                    }
                    if(fEvents[0].equals("TAC")){
                        synchronized (this){
                            //userEventEJB.updateUserEvents(fileName);
                        }
                        continue;
                    }
                    if(fEvents[0].equals("MCC")){
                        synchronized (this){
                            //marketOperatorEJB.updateMarketOperators(fileName);
                        }
                        continue;
                    }

                    if(fEvents[0].equals("Date / Time")){
                        synchronized (this){
                            failureEJB.postCSV(fileName);
                        }
                        continue;
                    }
                }else{
                    break;
                }
                lineNum++;
            }
        }finally {
            LineIterator.closeQuietly(lineIterator);
        }
    }

}
