package entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by C06590861 on 15/02/2017.
 */

@Entity
@Table(name = "failure_classes")
public class FailureClass implements Serializable {

	@Id
	@Column(name = "failure_class")
	private Integer failureClass;

	@Column(name = "description")
	private String description;

	public FailureClass() {
	}

	public FailureClass(Integer failureClass) {
		this.failureClass = failureClass;
	}

	public FailureClass(Integer failureClass, String description) {
		this.failureClass = failureClass;
		this.description = description;
	}

	public Integer getFailureClass() {
		return failureClass;
	}

	public void setFailureClass(Integer failureClass) {
		this.failureClass = failureClass;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
