package entities;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by c11456862 on 20/03/2017.
 */
public class EventCauseIDTest {
    @Test
    public void getEventID() throws Exception {
        EventCauseID ecID = new EventCauseID(0, 4097);
        assertNotNull(ecID);
        Integer x = 4097;
        assertEquals(x, ecID.getEventID());
    }

    @Test
    public void setEventID() throws Exception {
        EventCauseID ecID = new EventCauseID(0, 4097);
        ecID.setEventID(4098);
        Integer x = 4098;
        assertNotNull(ecID);
        assertEquals(x, ecID.getEventID());
    }

    @Test
    public void getCauseCode() throws Exception {
        EventCauseID ecID = new EventCauseID(0, 4097);
        assertNotNull(ecID);
        Integer x = 0;
        assertEquals(x, ecID.getCauseCode());
    }

    @Test
    public void setCauseCode() throws Exception {
        EventCauseID ecID = new EventCauseID(0, 4097);
        ecID.setCauseCode(1);
        Integer x = 1;
        assertNotNull(ecID);
        assertEquals(x, ecID.getCauseCode());
    }

}