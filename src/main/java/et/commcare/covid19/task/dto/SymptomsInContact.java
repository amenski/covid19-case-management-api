package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class SymptomsInContact {
	private HasContacts contactExperiencedRespiratorySymptomsAfter;
	private HasContacts contactExperiencedRespiratorySymptomsBefore;
	private HasContacts currentlyIll;
	private DateTimeFirstSymptomOnset dateTimeFirstSymptomOnset;
	private MaximumTemperature maximumTemperature;

	@JsonProperty("contact_experienced_respiratory_symptoms_after")
	public HasContacts getContactExperiencedRespiratorySymptomsAfter() {
		return contactExperiencedRespiratorySymptomsAfter;
	}

	@JsonProperty("contact_experienced_respiratory_symptoms_after")
	public void setContactExperiencedRespiratorySymptomsAfter(HasContacts value) {
		this.contactExperiencedRespiratorySymptomsAfter = value;
	}

	@JsonProperty("contact_experienced_respiratory_symptoms_before")
	public HasContacts getContactExperiencedRespiratorySymptomsBefore() {
		return contactExperiencedRespiratorySymptomsBefore;
	}

	@JsonProperty("contact_experienced_respiratory_symptoms_before")
	public void setContactExperiencedRespiratorySymptomsBefore(HasContacts value) {
		this.contactExperiencedRespiratorySymptomsBefore = value;
	}

	@JsonProperty("currently_ill")
	public HasContacts getCurrentlyIll() {
		return currentlyIll;
	}

	@JsonProperty("currently_ill")
	public void setCurrentlyIll(HasContacts value) {
		this.currentlyIll = value;
	}

	@JsonProperty("date_time_first_symptom_onset")
	public DateTimeFirstSymptomOnset getDateTimeFirstSymptomOnset() {
		return dateTimeFirstSymptomOnset;
	}

	@JsonProperty("date_time_first_symptom_onset")
	public void setDateTimeFirstSymptomOnset(DateTimeFirstSymptomOnset value) {
		this.dateTimeFirstSymptomOnset = value;
	}

	@JsonProperty("maximum_temperature")
	public MaximumTemperature getMaximumTemperature() {
		return maximumTemperature;
	}

	@JsonProperty("maximum_temperature")
	public void setMaximumTemperature(MaximumTemperature value) {
		this.maximumTemperature = value;
	}
}
