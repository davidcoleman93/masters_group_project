package entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by C06590861 on 14/02/2017.
 */

@Entity
@Table(name = "event_causes")
public class EventCause implements Serializable {

	@EmbeddedId
	private EventCauseID eventCauseID;

	@Column(name = "description")
	private String description;

	public EventCause() {
	}

	public EventCause(EventCauseID eventCauseID) {
		this.eventCauseID = eventCauseID;
	}

	public EventCause(EventCauseID eventCauseID, String description) {
		this.eventCauseID = eventCauseID;
		this.description = description;
	}

	public EventCauseID getEventCauseID() {
		return eventCauseID;
	}

	public void setEventCauseID(EventCauseID eventCauseID) {
		this.eventCauseID = eventCauseID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
