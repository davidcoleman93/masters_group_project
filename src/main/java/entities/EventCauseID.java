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

    @Column(name = "event_id") public Integer event_id;
    @Column(name = "cause_code") public Integer cause_code;

    public EventCauseID(){}

    public EventCauseID(int event_id, Integer cause_code){

        this.event_id = event_id;
        this.cause_code = cause_code;

    }

    public Integer getEventID() {
        return event_id;
    }

    public void setEventID(Integer event_id) {
        this.event_id = event_id;
    }

    public Integer getCauseCode() {
        return cause_code;
    }

    public void setCauseCode(Integer cause_code) {
        this.cause_code = cause_code;
    }

}