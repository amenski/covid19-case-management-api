package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class HealthCareInteractionsHospitalization {
	private String additionalNotesHospitalization;
	private String dateOfAdmissionToHospital;
	private String dateOfHospitalizationUnknown;
	private HasContacts hospitalizationHealthCareInteraction;
	private String nameAndPlaceOfHospital;

	@JsonProperty("additional_notes_hospitalization")
	public String getAdditionalNotesHospitalization() {
		return additionalNotesHospitalization;
	}

	@JsonProperty("additional_notes_hospitalization")
	public void setAdditionalNotesHospitalization(String value) {
		this.additionalNotesHospitalization = value;
	}

	@JsonProperty("date_of_admission_to_hospital")
	public String getDateOfAdmissionToHospital() {
		return dateOfAdmissionToHospital;
	}

	@JsonProperty("date_of_admission_to_hospital")
	public void setDateOfAdmissionToHospital(String value) {
		this.dateOfAdmissionToHospital = value;
	}

	@JsonProperty("date_of_hospitalization_unknown")
	public String getDateOfHospitalizationUnknown() {
		return dateOfHospitalizationUnknown;
	}

	@JsonProperty("date_of_hospitalization_unknown")
	public void setDateOfHospitalizationUnknown(String value) {
		this.dateOfHospitalizationUnknown = value;
	}

	@JsonProperty("hospitalization_health-care_interaction")
	public HasContacts getHospitalizationHealthCareInteraction() {
		return hospitalizationHealthCareInteraction;
	}

	@JsonProperty("hospitalization_health-care_interaction")
	public void setHospitalizationHealthCareInteraction(HasContacts value) {
		this.hospitalizationHealthCareInteraction = value;
	}

	@JsonProperty("name_and_place_of_hospital")
	public String getNameAndPlaceOfHospital() {
		return nameAndPlaceOfHospital;
	}

	@JsonProperty("name_and_place_of_hospital")
	public void setNameAndPlaceOfHospital(String value) {
		this.nameAndPlaceOfHospital = value;
	}
}
