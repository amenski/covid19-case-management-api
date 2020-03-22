package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Status {
	private String outcomeStatus;

	@JsonProperty("outcome_status")
	public String getOutcomeStatus() {
		return outcomeStatus;
	}

	@JsonProperty("outcome_status")
	public void setOutcomeStatus(String value) {
		this.outcomeStatus = value;
	}
}
