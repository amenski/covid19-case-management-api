package et.covid19.rest.dal.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the workflow database table.
 * 
 */
@Embeddable
public class WorkflowPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="start_state")
	private Integer startState;

	@Column(name="end_state")
	private Integer endState;

	public WorkflowPK() {
	    //
	}
	public Integer getStartState() {
		return this.startState;
	}
	public void setStartState(Integer startState) {
		this.startState = startState;
	}
	public Integer getEndState() {
		return this.endState;
	}
	public void setEndState(Integer endState) {
		this.endState = endState;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof WorkflowPK)) {
			return false;
		}
		WorkflowPK castOther = (WorkflowPK)other;
		return 
			this.startState.equals(castOther.startState)
			&& this.endState.equals(castOther.endState);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.startState.hashCode();
		hash = hash * prime + this.endState.hashCode();
		
		return hash;
	}
}