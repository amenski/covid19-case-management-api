package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class CurrentStatusClass {
	private String currentStatus;
	private PatientCaseStatus patientCaseStatus;
	private String suspectedLabel;
	private String confirmLabel;

	@JsonProperty("current_status")
	public String getCurrentStatus() {
		return currentStatus;
	}

	@JsonProperty("current_status")
	public void setCurrentStatus(String value) {
		this.currentStatus = value;
	}

	@JsonProperty("patient_case_status")
	public PatientCaseStatus getPatientCaseStatus() {
		return patientCaseStatus;
	}

	@JsonProperty("patient_case_status")
	public void setPatientCaseStatus(PatientCaseStatus value) {
		this.patientCaseStatus = value;
	}

	@JsonProperty("suspected_label")
	public String getSuspectedLabel() {
		return suspectedLabel;
	}

	@JsonProperty("suspected_label")
	public void setSuspectedLabel(String value) {
		this.suspectedLabel = value;
	}

	@JsonProperty("confirm_label")
	public String getConfirmLabel() {
		return confirmLabel;
	}

	@JsonProperty("confirm_label")
	public void setConfirmLabel(String value) {
		this.confirmLabel = value;
	}
}
