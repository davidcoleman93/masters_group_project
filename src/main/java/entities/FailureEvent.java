package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by C06590861 on 15/02/2017.
 */

@Entity
@Table(name = "failure_events")
public class FailureEvent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") private Integer id;

    //Just need to get DATE data type working!
    @Column(name = "date_time") private String dateTime;

    @JoinColumns({
            @JoinColumn(name = "cause_code", referencedColumnName = "cause_code"),
            @JoinColumn(name = "event_id", referencedColumnName = "event_id")
    })
    @ManyToOne
    private EventCause eventCause;

    @JoinColumn(name = "failure_class", referencedColumnName = "failure_class")
    @ManyToOne
    private FailureClass failureClass;

    @JoinColumn(name = "ue_type", referencedColumnName = "tac")
    @ManyToOne
    private UserEventType userEventType;

    @JoinColumns({
            @JoinColumn(name = "market", referencedColumnName = "mcc"),
            @JoinColumn(name = "operator", referencedColumnName = "mnc")
    })
    @ManyToOne
    private MarketOperator marketOperator;

    @Column(name = "cell_id") private Integer cellID;
    @Column(name = "duration") private Integer duration;
    @Column(name = "ne_version") private String neVersion;
    @Column(name = "imsi") private Long imsi;

    public FailureEvent() {
    }

    public FailureEvent(String dateTime,
                        EventCause eventCause,
                        FailureClass failureClass,
                        UserEventType userEventType,
                        MarketOperator marketOperator,
                        Integer cellID,
                        Integer duration,
                        String neVersion,
                        Long imsi) {
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

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
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

    public String getNeVersion() {
        return neVersion;
    }

    public void setNeVersion(String neVersion) {
        this.neVersion = neVersion;
    }

    public Long getImsi() {
        return imsi;
    }

    public void setImsi(Long imsi) {
        this.imsi = imsi;
    }

}