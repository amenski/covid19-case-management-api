package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class DateTimeFirstSymptomOnset {
	private String dateOfFirstSymptomOnset;
	private String timeOfFirstSymptomOnset;

	@JsonProperty("date_of_first_symptom_onset")
	public String getDateOfFirstSymptomOnset() {
		return dateOfFirstSymptomOnset;
	}

	@JsonProperty("date_of_first_symptom_onset")
	public void setDateOfFirstSymptomOnset(String value) {
		this.dateOfFirstSymptomOnset = value;
	}

	@JsonProperty("time_of_first_symptom_onset")
	public String getTimeOfFirstSymptomOnset() {
		return timeOfFirstSymptomOnset;
	}

	@JsonProperty("time_of_first_symptom_onset")
	public void setTimeOfFirstSymptomOnset(String value) {
		this.timeOfFirstSymptomOnset = value;
	}
}
