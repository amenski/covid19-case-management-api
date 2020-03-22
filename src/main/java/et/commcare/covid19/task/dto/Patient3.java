package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Patient3 {
	private String patientEthnicity;
	private String patientNurserySchoolCollege;
	private String patientResponsibleHealthCentre;

	@JsonProperty("patient_ethnicity")
	public String getPatientEthnicity() {
		return patientEthnicity;
	}

	@JsonProperty("patient_ethnicity")
	public void setPatientEthnicity(String value) {
		this.patientEthnicity = value;
	}

	@JsonProperty("patient_nursery_school_college")
	public String getPatientNurserySchoolCollege() {
		return patientNurserySchoolCollege;
	}

	@JsonProperty("patient_nursery_school_college")
	public void setPatientNurserySchoolCollege(String value) {
		this.patientNurserySchoolCollege = value;
	}

	@JsonProperty("patient_responsible_health_centre")
	public String getPatientResponsibleHealthCentre() {
		return patientResponsibleHealthCentre;
	}

	@JsonProperty("patient_responsible_health_centre")
	public void setPatientResponsibleHealthCentre(String value) {
		this.patientResponsibleHealthCentre = value;
	}
}
