package entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by C06590861 on 16/02/2017.
 */

//@Embeddable allows us to use a composite key as a primary key in the parent table

@Embeddable
public class EventCauseID implements Serializable {

    @Column(name = "event_id") public int eventID;
    @Column(name = "cause_code") public int causeCode;

    public EventCauseID(){}

    public EventCauseID(int causeCode, int eventID){

        this.eventID = eventID;
        this.causeCode = causeCode;

    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public int getCauseCode() {
        return causeCode;
    }

    public void setCauseCode(int causeCode) {
        this.causeCode = causeCode;
    }

}