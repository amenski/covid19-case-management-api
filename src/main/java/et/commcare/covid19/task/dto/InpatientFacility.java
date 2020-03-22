package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class InpatientFacility {
	private String visitedOrAdmittedInpatient;

	@JsonProperty("visited_or_admitted_inpatient")
	public String getVisitedOrAdmittedInpatient() {
		return visitedOrAdmittedInpatient;
	}

	@JsonProperty("visited_or_admitted_inpatient")
	public void setVisitedOrAdmittedInpatient(String value) {
		this.visitedOrAdmittedInpatient = value;
	}
}
