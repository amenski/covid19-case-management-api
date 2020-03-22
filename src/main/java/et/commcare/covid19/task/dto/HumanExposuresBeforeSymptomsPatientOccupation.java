package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class HumanExposuresBeforeSymptomsPatientOccupation {
	private String patientOccupation;
	private String locationFacility;
	private String otherOccupation;

	@JsonProperty("patient_occupation")
	public String getPatientOccupation() {
		return patientOccupation;
	}

	@JsonProperty("patient_occupation")
	public void setPatientOccupation(String value) {
		this.patientOccupation = value;
	}

	@JsonProperty("location_facility")
	public String getLocationFacility() {
		return locationFacility;
	}

	@JsonProperty("location_facility")
	public void setLocationFacility(String value) {
		this.locationFacility = value;
	}

	@JsonProperty("other_occupation")
	public String getOtherOccupation() {
		return otherOccupation;
	}

	@JsonProperty("other_occupation")
	public void setOtherOccupation(String value) {
		this.otherOccupation = value;
	}
}
