package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class OutpatientFacility {
	private String visitedOutpatient;

	@JsonProperty("visited_outpatient")
	public String getVisitedOutpatient() {
		return visitedOutpatient;
	}

	@JsonProperty("visited_outpatient")
	public void setVisitedOutpatient(String value) {
		this.visitedOutpatient = value;
	}
}
