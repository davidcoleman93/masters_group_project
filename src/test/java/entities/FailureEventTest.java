package entities;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by c11456862 on 20/03/2017.
 */

/*
Date dateTime,
        EventCause eventCause,
        FailureClass failureClass,
        UserEventType userEventType,
        MarketOperator marketOperator,
        Integer cellID,
        Integer duration,
        String neVersion,
        Long imsi)
        */
public class FailureEventTest {
    @Test
    public void getId() throws Exception {
        EventCauseID ecID = new EventCauseID(0, 4097);
        EventCause eCause = new EventCause(ecID, "testDescription");
        FailureClass fClass = new FailureClass(0, "test description");
        UserEventType uet = new UserEventType(100100, "G410", "Mitibishi",
                "GSM 1800, GSM 900", "G410", "Mitsubishi",
                "HANDHELD", "testOS", "testInputMode");
        MarketOperatorID moID = new MarketOperatorID(238, 1);
        MarketOperator mOperator = new MarketOperator(moID, "Denmark", "TDC-DK");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = df.parse("2013-11-01 17:15:00");
        Long imsi = 344930000000011L;
        FailureEvent fEvent = new FailureEvent(date, eCause, fClass, uet, mOperator, 4, 1000,
                "11B", imsi);

        fEvent.setId(1);
        assertNotNull(fEvent);
        Integer x = 1;
        assertEquals(x, fEvent.getId());
    }

    @Test
    public void setId() throws Exception {
        EventCauseID ecID = new EventCauseID(0, 4097);
        EventCause eCause = new EventCause(ecID, "testDescription");
        FailureClass fClass = new FailureClass(0, "test description");
        UserEventType uet = new UserEventType(100100, "G410", "Mitibishi",
                "GSM 1800, GSM 900", "G410", "Mitsubishi",
                "HANDHELD", "testOS", "testInputMode");
        MarketOperatorID moID = new MarketOperatorID(238, 1);
        MarketOperator mOperator = new MarketOperator(moID, "Denmark", "TDC-DK");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = df.parse("2013-11-01 17:15:00");
        Long imsi = 344930000000011L;
        FailureEvent fEvent = new FailureEvent(date, eCause, fClass, uet, mOperator, 4, 1000,
                "11B", imsi);

        Integer x = 1;
        fEvent.setId(1);
        assertNotNull(fEvent);
        assertEquals(x, fEvent.getId());
    }

    @Test
    public void getDateTime() throws Exception {
        EventCauseID ecID = new EventCauseID(0, 4097);
        EventCause eCause = new EventCause(ecID, "testDescription");
        FailureClass fClass = new FailureClass(0, "test description");
        UserEventType uet = new UserEventType(100100, "G410", "Mitibishi",
                "GSM 1800, GSM 900", "G410", "Mitsubishi",
                "HANDHELD", "testOS", "testInputMode");
        MarketOperatorID moID = new MarketOperatorID(238, 1);
        MarketOperator mOperator = new MarketOperator(moID, "Denmark", "TDC-DK");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = df.parse("2013-11-01 17:15:00");
        Long imsi = 344930000000011L;
        FailureEvent fEvent = new FailureEvent(date, eCause, fClass, uet, mOperator, 4, 1000,
                "11B", imsi);

        Date x = df.parse("2013-11-01 17:15:00");
        assertNotNull(fEvent);

        assertEquals(x, fEvent.getDateTime());
    }

    @Test
    public void setDateTime() throws Exception {
        EventCauseID ecID = new EventCauseID(0, 4097);
        EventCause eCause = new EventCause(ecID, "testDescription");
        FailureClass fClass = new FailureClass(0, "test description");
        UserEventType uet = new UserEventType(100100, "G410", "Mitibishi",
                "GSM 1800, GSM 900", "G410", "Mitsubishi",
                "HANDHELD", "testOS", "testInputMode");
        MarketOperatorID moID = new MarketOperatorID(238, 1);
        MarketOperator mOperator = new MarketOperator(moID, "Denmark", "TDC-DK");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = df.parse("2013-11-01 17:15:00");
        Long imsi = 344930000000011L;
        FailureEvent fEvent = new FailureEvent(date, eCause, fClass, uet, mOperator, 4, 1000,
                "11B", imsi);

        Date x = df.parse("2014-12-04 18:30:00");

        fEvent.setDateTime(df.parse("2014-12-04 18:30:00"));
        assertNotNull(fEvent);

        assertEquals(x, fEvent.getDateTime());
    }

    @Test
    public void getEventCause() throws Exception {

    }

    @Test
    public void setEventCause() throws Exception {

    }

    @Test
    public void getFailureClass() throws Exception {

    }

    @Test
    public void setFailureClass() throws Exception {

    }

    @Test
    public void getUserEventType() throws Exception {

    }

    @Test
    public void setUserEventType() throws Exception {

    }

    @Test
    public void getMarketOperator() throws Exception {

    }

    @Test
    public void setMarketOperator() throws Exception {

    }

    @Test
    public void getCellID() throws Exception {

    }

    @Test
    public void setCellID() throws Exception {

    }

    @Test
    public void getDuration() throws Exception {

    }

    @Test
    public void setDuration() throws Exception {

    }

    @Test
    public void getNeVersion() throws Exception {

    }

    @Test
    public void setNeVersion() throws Exception {

    }

    @Test
    public void getImsi() throws Exception {

    }

    @Test
    public void setImsi() throws Exception {

    }

}