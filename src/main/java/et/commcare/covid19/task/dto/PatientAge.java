package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class PatientAge {
	private String patientAgeMonths;
	private String patientAgeUnknown;
	private String patientAgeYears;
	private String whatIsThePatientsApproximateAge;

	@JsonProperty("patient_age_months")
	public String getPatientAgeMonths() {
		return patientAgeMonths;
	}

	@JsonProperty("patient_age_months")
	public void setPatientAgeMonths(String value) {
		this.patientAgeMonths = value;
	}

	@JsonProperty("patient_age_unknown")
	public String getPatientAgeUnknown() {
		return patientAgeUnknown;
	}

	@JsonProperty("patient_age_unknown")
	public void setPatientAgeUnknown(String value) {
		this.patientAgeUnknown = value;
	}

	@JsonProperty("patient_age_years")
	public String getPatientAgeYears() {
		return patientAgeYears;
	}

	@JsonProperty("patient_age_years")
	public void setPatientAgeYears(String value) {
		this.patientAgeYears = value;
	}

	@JsonProperty("what_is_the_patients_approximate_age")
	public String getWhatIsThePatientsApproximateAge() {
		return whatIsThePatientsApproximateAge;
	}

	@JsonProperty("what_is_the_patients_approximate_age")
	public void setWhatIsThePatientsApproximateAge(String value) {
		this.whatIsThePatientsApproximateAge = value;
	}
}
