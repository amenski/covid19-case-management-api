package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class OtherDetails {
	private String patientAddress;
	private String patientCountryOfResidence;
	private String patientEmail;
	private String patientNationalSocialNumberIdentifier;
	private String patientNationality;

	@JsonProperty("patient_address")
	public String getPatientAddress() {
		return patientAddress;
	}

	@JsonProperty("patient_address")
	public void setPatientAddress(String value) {
		this.patientAddress = value;
	}

	@JsonProperty("patient_country_of_residence")
	public String getPatientCountryOfResidence() {
		return patientCountryOfResidence;
	}

	@JsonProperty("patient_country_of_residence")
	public void setPatientCountryOfResidence(String value) {
		this.patientCountryOfResidence = value;
	}

	@JsonProperty("patient_email")
	public String getPatientEmail() {
		return patientEmail;
	}

	@JsonProperty("patient_email")
	public void setPatientEmail(String value) {
		this.patientEmail = value;
	}

	@JsonProperty("patient_national_social_number_identifier")
	public String getPatientNationalSocialNumberIdentifier() {
		return patientNationalSocialNumberIdentifier;
	}

	@JsonProperty("patient_national_social_number_identifier")
	public void setPatientNationalSocialNumberIdentifier(String value) {
		this.patientNationalSocialNumberIdentifier = value;
	}

	@JsonProperty("patient_nationality")
	public String getPatientNationality() {
		return patientNationality;
	}

	@JsonProperty("patient_nationality")
	public void setPatientNationality(String value) {
		this.patientNationality = value;
	}
}
