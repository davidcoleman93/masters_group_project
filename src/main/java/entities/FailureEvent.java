package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by C06590861 on 15/02/2017.
 */

//@Entity
//@Table(name = "failure_events")
public class FailureEvent implements Serializable {

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id") private Integer id;

    @Column(name = "date_time") private Date dateTime;

    @Column(name = "event_id") private EventCause eventCause;

    *//*@MapsId("eventID")
    @JoinColumns({
            @JoinColumn(name="event_id", referencedColumnName="event_id"),
            @JoinColumn(name="SourceID", referencedColumnName="SourceID")
    })
    @ManyToOne
    private EventCause eventCause;*/



}