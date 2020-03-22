package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class OutcomeCurrentAsOfDate {
	private String outcomeCurrentAsOfDate;
	private String outcomeCurrentAsOfDateOther;

	@JsonProperty("outcome_current_as_of_date")
	public String getOutcomeCurrentAsOfDate() {
		return outcomeCurrentAsOfDate;
	}

	@JsonProperty("outcome_current_as_of_date")
	public void setOutcomeCurrentAsOfDate(String value) {
		this.outcomeCurrentAsOfDate = value;
	}

	@JsonProperty("outcome_current_as_of_date_other")
	public String getOutcomeCurrentAsOfDateOther() {
		return outcomeCurrentAsOfDateOther;
	}

	@JsonProperty("outcome_current_as_of_date_other")
	public void setOutcomeCurrentAsOfDateOther(String value) {
		this.outcomeCurrentAsOfDateOther = value;
	}
}
