package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by C06590861 on 15/02/2017.
 */

@Entity
@Table(name = "failure_events")
public class FailureEvent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") private Integer id;

    @Column(name = "date_time") private Date dateTime;

    @MapsId("eventCauseID")
    @JoinColumns({
            @JoinColumn(name = "event_id", referencedColumnName = "event_id"),
            @JoinColumn(name = "cause_code", referencedColumnName = "cause_code")
    })
    @ManyToOne
    private EventCause eventCause;

    @MapsId("failureClass")
    @JoinColumn(name = "failure_class", referencedColumnName = "failure_class")
    @ManyToOne
    private FailureClass failureClass;

    @MapsId("tac")
    @JoinColumn(name = "ue_type", referencedColumnName = "tac")
    @ManyToOne
    private UserEventType userEventType;

    @MapsId("marketOpID")
    @JoinColumns({
            @JoinColumn(name = "market", referencedColumnName = "mcc"),
            @JoinColumn(name = "operator", referencedColumnName = "mnc")
    })
    @ManyToOne
    private MarketOperator marketOperator;

    @Column(name = "cell_id") private Integer cellID;
    @Column(name = "duration") private Integer duration;
    @Column(name = "ne_version") private Integer neVersion;
    @Column(name = "imsi") private long imsi;

    public FailureEvent() {
    }

    public FailureEvent(Date dateTime, EventCause eventCause, FailureClass failureClass,
                        UserEventType userEventType, MarketOperator marketOperator, Integer cellID,
                        Integer duration, Integer neVersion, long imsi) {
        this.dateTime = dateTime;
        this.eventCause = eventCause;
        this.failureClass = failureClass;
        this.userEventType = userEventType;
        this.marketOperator = marketOperator;
        this.cellID = cellID;
        this.duration = duration;
        this.neVersion = neVersion;
        this.imsi = imsi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public EventCause getEventCause() {
        return eventCause;
    }

    public void setEventCause(EventCause eventCause) {
        this.eventCause = eventCause;
    }

    public FailureClass getFailureClass() {
        return failureClass;
    }

    public void setFailureClass(FailureClass failureClass) {
        this.failureClass = failureClass;
    }

    public UserEventType getUserEventType() {
        return userEventType;
    }

    public void setUserEventType(UserEventType userEventType) {
        this.userEventType = userEventType;
    }

    public MarketOperator getMarketOperator() {
        return marketOperator;
    }

    public void setMarketOperator(MarketOperator marketOperator) {
        this.marketOperator = marketOperator;
    }

    public Integer getCellID() {
        return cellID;
    }

    public void setCellID(Integer cellID) {
        this.cellID = cellID;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getNeVersion() {
        return neVersion;
    }

    public void setNeVersion(Integer neVersion) {
        this.neVersion = neVersion;
    }

    public long getImsi() {
        return imsi;
    }

    public void setImsi(long imsi) {
        this.imsi = imsi;
    }

}