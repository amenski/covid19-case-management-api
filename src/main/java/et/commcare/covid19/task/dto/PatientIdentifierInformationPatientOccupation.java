package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class PatientIdentifierInformationPatientOccupation {
	private String occupationLocationFacilityPtID;
	private String otherOccupationPtID;
	private String patientOccupationPtID;

	@JsonProperty("occupation_location_facility_pt_id")
	public String getOccupationLocationFacilityPtID() {
		return occupationLocationFacilityPtID;
	}

	@JsonProperty("occupation_location_facility_pt_id")
	public void setOccupationLocationFacilityPtID(String value) {
		this.occupationLocationFacilityPtID = value;
	}

	@JsonProperty("other_occupation_pt_id")
	public String getOtherOccupationPtID() {
		return otherOccupationPtID;
	}

	@JsonProperty("other_occupation_pt_id")
	public void setOtherOccupationPtID(String value) {
		this.otherOccupationPtID = value;
	}

	@JsonProperty("patient_occupation_pt_id")
	public String getPatientOccupationPtID() {
		return patientOccupationPtID;
	}

	@JsonProperty("patient_occupation_pt_id")
	public void setPatientOccupationPtID(String value) {
		this.patientOccupationPtID = value;
	}
}
