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
    @Column(name="failure_class") private Integer failure_class;

    @Column(name="description") private String description;

    public FailureClass(){}

    public FailureClass(Integer failure_class, String description) {
        this.failure_class = failure_class;
        this.description = description;
    }

    public Integer getFailure_class() {
        return failure_class;
    }

    public void setFailure_class(Integer failure_class) {
        this.failure_class = failure_class;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
