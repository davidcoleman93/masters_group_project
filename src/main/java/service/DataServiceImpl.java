package service;

import dao.*;
import entities.*;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Collection;
import java.util.Date;

/**
 * Created by C06590861 on 23/02/2017.
 */

@Local
@Stateless
public class DataServiceImpl implements DataServiceLocal {

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

    //BELOW IS A HARD CODED, 'SUCCESSFUL', FAILURE EVENT
//    private String date = "11/01/2013  17:31:00";
//    private String neVersion = "11B";
//    private int eventID = 4098;
//    private int failureClass = 1;
//    private int ueType = 21060800;
//    private int market = 238;
//    private int operator = 1;
//    private int cellID = 4;
//    private int duration = 1000;
//    private int causeCode = 0;
//    long imsi = 344930000000011L;

    public void addData(Date date, String neVersion, Integer eventID, Integer failureClass, Integer ueType, Integer market, Integer operator, Integer cellID, Integer duration, Integer causeCode, long imsi){
    	//System.out.println("\n\n\nData Start\n\n\n\n");
    	
        if(checkEventCause(causeCode, eventID) && checkFailureClass(failureClass)
                && checkMarketOperator(market, operator) && checkUserEventType(ueType)){

                FailureClass tempFailureClass;
                EventCause tempEventCause;
                UserEventType tempUserEventType;
                MarketOperator tempMarketOperator;

                try{
                    tempEventCause = eventCauseBean.getEventCause(new EventCauseID(causeCode, eventID));
                    try{
                        tempFailureClass = failureClassBean.getFailureClass(failureClass);
                        try{
                            tempUserEventType = ueTypeBean.getUserEventType(ueType);
                            try{
                                tempMarketOperator = marketOperatorBean.getMarketOperator(
                                        new MarketOperatorID(market, operator));

                                //for(int i = 0; i < 30000; i++){
                                    dataBean.addFailureEvent(new FailureEvent(
                                            date,
                                            tempEventCause,
                                            tempFailureClass,
                                            tempUserEventType,
                                            tempMarketOperator,
                                            cellID,
                                            duration,
                                            neVersion,
                                            imsi));
                                    //System.out.println(i);
                                //}
                            }catch (Exception e){
                                System.out.println("WRONG MARKET OPERATOR");
                            }
                        }catch (Exception e){
                            System.out.println("WRONG USER EVENT TYPE");
                        }
                    }catch (Exception e){
                        System.out.println("WRONG FAILURE CLASS");
                    }
                }catch(Exception e){
                    System.out.println("WRONG EVENT CAUSE");
                }

        } else{
            System.out.println("WRONG DATA SUPPLIED");
        }
        //System.out.println("\n\n\nData End\n\n\n\n");
    }

    public Collection<?> getCallFailures(){
        return dataBean.getCallFailures();
    }

    public boolean checkEventCause(Integer causeCode, Integer eventID){
        EventCauseID temp = new EventCauseID(causeCode, eventID);
        EventCause tempEvent;
        try{
            tempEvent = eventCauseBean.getEventCause(temp);
            if(tempEvent == null){
                return false;
            }
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean checkFailureClass(Integer failureClass){
        FailureClass temp;
        try{
            temp = failureClassBean.getFailureClass(failureClass);
            if(temp == null){
                return false;
            }
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean checkMarketOperator(Integer market, Integer operator){
        MarketOperatorID temp = new MarketOperatorID(market, operator);
        MarketOperator tempMarketOp;
        try{
            tempMarketOp = marketOperatorBean.getMarketOperator(temp);
            if(tempMarketOp == null){
                return false;
            }
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean checkUserEventType(Integer userEventType){
        UserEventType temp;
        try{
            temp = ueTypeBean.getUserEventType(userEventType);
            if(temp == null){
                return false;
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
