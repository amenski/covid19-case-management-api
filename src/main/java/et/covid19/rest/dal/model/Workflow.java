package et.covid19.rest.dal.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the workflow database table.
 * 
 */
@Entity
@NamedQuery(name="Workflow.findAll", query="SELECT w FROM Workflow w")
public class Workflow implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private WorkflowPK id;

	private String description;

	private boolean disabled;

	public Workflow() {
	    //
	}

	public WorkflowPK getId() {
		return this.id;
	}

	public void setId(WorkflowPK id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

}