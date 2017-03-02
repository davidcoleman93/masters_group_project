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

    @Column(name = "event_id") public Integer eventID;
    @Column(name = "cause_code") public Integer causeCode;

    public EventCauseID(){}

    public EventCauseID(Integer causeCode, Integer eventID){

        this.eventID = eventID;
        this.causeCode = causeCode;

    }

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public Integer getCauseCode() {
        return causeCode;
    }

    public void setCauseCode(Integer causeCode) {
        this.causeCode = causeCode;
    }

}