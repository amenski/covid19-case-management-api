package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Name {
	private String patientFamilyName;
	private String patientFirstName;
	private String patientInfo;

	@JsonProperty("patient_family_name")
	public String getPatientFamilyName() {
		return patientFamilyName;
	}

	@JsonProperty("patient_family_name")
	public void setPatientFamilyName(String value) {
		this.patientFamilyName = value;
	}

	@JsonProperty("patient_first_name")
	public String getPatientFirstName() {
		return patientFirstName;
	}

	@JsonProperty("patient_first_name")
	public void setPatientFirstName(String value) {
		this.patientFirstName = value;
	}

	@JsonProperty("patient_info")
	public String getPatientInfo() {
		return patientInfo;
	}

	@JsonProperty("patient_info")
	public void setPatientInfo(String value) {
		this.patientInfo = value;
	}
}
