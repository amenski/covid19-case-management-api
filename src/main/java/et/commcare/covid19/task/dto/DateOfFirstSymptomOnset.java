package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class DateOfFirstSymptomOnset {
	private String dateOfFirstSymptomOnsetKnown;
	private String dateOfFirstSymptomOnsetLabel;

	@JsonProperty("date_of_first_symptom_onset_known")
	public String getDateOfFirstSymptomOnsetKnown() {
		return dateOfFirstSymptomOnsetKnown;
	}

	@JsonProperty("date_of_first_symptom_onset_known")
	public void setDateOfFirstSymptomOnsetKnown(String value) {
		this.dateOfFirstSymptomOnsetKnown = value;
	}

	@JsonProperty("date_of_first_symptom_onset_label")
	public String getDateOfFirstSymptomOnsetLabel() {
		return dateOfFirstSymptomOnsetLabel;
	}

	@JsonProperty("date_of_first_symptom_onset_label")
	public void setDateOfFirstSymptomOnsetLabel(String value) {
		this.dateOfFirstSymptomOnsetLabel = value;
	}
}
