package service.data;

import com.google.common.collect.Multimap;
import dao.EventCauseDAOLocal;
import entities.EventCause;
import entities.EventCauseID;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;

/**
 * Created by david on 28/03/2017.
 */

@Local
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class EventCauseValidationEJB implements EventCauseValidationEJBLocal {

    @Inject
    private EventCauseDAOLocal eventCauseBean;

    public void updateEventCause(String fileName){
        File temp;
        LineIterator lineIterator = null;

        Multimap<Integer, Integer> eventCauseMap = null;
        int lineNum = 0;

        //Data types for Event Cause Types
        Integer causeCode;
        Integer eventID;
        String description;

        String[] eventCauses;

        boolean error;

        try{
            temp = new File(fileName);
            lineIterator = FileUtils.lineIterator(temp, "UTF-8");
        }catch(Exception ioe){
        }

        //Data structure to hold the composite primary keys
        try{
            eventCauseMap = eventCauseBean.getEventCauseMap();
        }catch (Exception e){
            System.out.println("ERROR IN PARSING FAILURE CLASS TO MULTIMAP");
        }

        try{
            System.out.println("STARTED");
            while(lineIterator.hasNext()){
                eventCauses = lineIterator.nextLine().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if(lineNum == 0){
                    lineNum++;
                }else{
                    causeCode = null;
                    eventID = null;
                    description = null;

                    error = false;

                    try{
                        causeCode = Integer.parseInt(eventCauses[0]);
                        eventID = Integer.parseInt(eventCauses[1]);
                    }catch (Exception e) {
                        if(!error) error = true;
                    }
                    if(!eventCauseMap.containsEntry(causeCode, eventID) && !error){
                        try{
                            description = eventCauses[2];
                        }catch (Exception e){
                            if(!error) error = true;
                        }

                        if(!error){
                            eventCauseBean.addEventCause(
                                    new EventCause(
                                            new EventCauseID(
                                                    causeCode,
                                                    eventID
                                            ),
                                            description
                                    )
                            );
                        }
                    }
                }
            }
        }finally {
            LineIterator.closeQuietly(lineIterator);
        }
        System.out.println("COMPLETED");
    }

    public Collection<?> allEventCauses(){
        return eventCauseBean.allEventCauses();
    }
}
