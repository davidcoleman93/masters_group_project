package entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by C06590861 on 15/03/2017.
 */

@Entity
@Table(name = "failure_events_log")
public class FailureEventLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") private Integer id;

    @Column(name = "date_time") private Date dateTime;
    @Column(name = "event_id") private Integer eventID;
    @Column(name = "failure_class") private Integer failureClass;
    @Column(name = "ue_type") private Integer ueType;
    @Column(name = "market") private Integer market;
    @Column(name = "operator") private Integer operator;
    @Column(name = "cell_id") private Integer cellID;
    @Column(name = "duration") private Integer duration;
    @Column(name = "cause_code") private Integer causeCode;
    @Column(name = "ne_version") private String neVersion;
    @Column(name = "imsi") private Long imsi;

    public FailureEventLog() {
    }

    public FailureEventLog(Date dateTime, Integer eventID, Integer failureClass, Integer ueType, Integer market, Integer operator, Integer cellID, Integer duration, Integer causeCode, String neVersion, Long imsi) {
        this.dateTime = dateTime;
        this.eventID = eventID;
        this.failureClass = failureClass;
        this.ueType = ueType;
        this.market = market;
        this.operator = operator;
        this.cellID = cellID;
        this.duration = duration;
        this.causeCode = causeCode;
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

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public Integer getFailureClass() {
        return failureClass;
    }

    public void setFailureClass(Integer failureClass) {
        this.failureClass = failureClass;
    }

    public Integer getUeType() {
        return ueType;
    }

    public void setUeType(Integer ueType) {
        this.ueType = ueType;
    }

    public Integer getMarket() {
        return market;
    }

    public void setMarket(Integer market) {
        this.market = market;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
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

    public Integer getCauseCode() {
        return causeCode;
    }

    public void setCauseCode(Integer causeCode) {
        this.causeCode = causeCode;
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
