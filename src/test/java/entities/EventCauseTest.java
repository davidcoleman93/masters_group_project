package entities;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by c11456862 on 15/03/2017.
 */
public class EventCauseTest {
    @Test
    public void getEventCauseID() throws Exception {
        EventCauseID ecID = new EventCauseID(0, 4097);
        EventCause eCause = new EventCause(ecID, "testDescription");
        assertNotNull(eCause);
        Integer x = 0;
        Integer y = 4097;
        assertEquals(ecID, eCause.getEventCauseID());
        assertEquals(x, eCause.getEventCauseID().getCauseCode());
        assertEquals(y, eCause.getEventCauseID().getEventID());
    }

    @Test
    public void setEventCauseID() throws Exception {
        EventCauseID ecID = new EventCauseID(0, 4097);
        EventCause eCause = new EventCause(ecID, "testDescription");

        EventCauseID ecID2 = new EventCauseID(1, 4098);
        eCause.setEventCauseID(ecID2);
        Integer x = 1;
        Integer y = 4098;
        assertNotNull(eCause);
        assertEquals(ecID2, eCause.getEventCauseID());
        assertEquals(x, eCause.getEventCauseID().getCauseCode());
        assertEquals(y, eCause.getEventCauseID().getEventID());
    }

    @Test
    public void getDescription() throws Exception {
        EventCauseID ecID = new EventCauseID(0, 4097);
        EventCause eCause = new EventCause(ecID, "testDescription");
        assertNotNull(eCause);
        String x = "testDescription";

        assertEquals(x, eCause.getDescription());
    }

    @Test
    public void setDescription() throws Exception {
        EventCauseID ecID = new EventCauseID(0, 4097);
        EventCause eCause = new EventCause(ecID, "testDescription");

        eCause.setDescription("newDescription");
        String x = "newDescription";
        assertNotNull(eCause);
        assertEquals(x, eCause.getDescription());
    }

}