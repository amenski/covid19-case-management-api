package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class PatientIdentifierInformationDateOfBirth {
	private AgeComponentMath ageComponentMath;
	private String patientDateOfBirthUnknown;
	private String patientDateOfBirth;

	@JsonProperty("age_component_math")
	public AgeComponentMath getAgeComponentMath() {
		return ageComponentMath;
	}

	@JsonProperty("age_component_math")
	public void setAgeComponentMath(AgeComponentMath value) {
		this.ageComponentMath = value;
	}

	@JsonProperty("patient_date_of_birth_unknown")
	public String getPatientDateOfBirthUnknown() {
		return patientDateOfBirthUnknown;
	}

	@JsonProperty("patient_date_of_birth_unknown")
	public void setPatientDateOfBirthUnknown(String value) {
		this.patientDateOfBirthUnknown = value;
	}

	@JsonProperty("patient_date_of_birth")
	public String getPatientDateOfBirth() {
		return patientDateOfBirth;
	}

	@JsonProperty("patient_date_of_birth")
	public void setPatientDateOfBirth(String value) {
		this.patientDateOfBirth = value;
	}
}
