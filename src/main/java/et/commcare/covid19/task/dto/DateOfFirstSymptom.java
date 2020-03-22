package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class DateOfFirstSymptom {
	private String dateOfFirstSymptomOnset;
	private CommentLabel dateOfFirstSymptomOnsetLabel;
	private String dateOfFirstSymptomOnsetOther;

	@JsonProperty("date_of_first_symptom_onset")
	public String getDateOfFirstSymptomOnset() {
		return dateOfFirstSymptomOnset;
	}

	@JsonProperty("date_of_first_symptom_onset")
	public void setDateOfFirstSymptomOnset(String value) {
		this.dateOfFirstSymptomOnset = value;
	}

	@JsonProperty("date_of_first_symptom_onset_label")
	public CommentLabel getDateOfFirstSymptomOnsetLabel() {
		return dateOfFirstSymptomOnsetLabel;
	}

	@JsonProperty("date_of_first_symptom_onset_label")
	public void setDateOfFirstSymptomOnsetLabel(CommentLabel value) {
		this.dateOfFirstSymptomOnsetLabel = value;
	}

	@JsonProperty("date_of_first_symptom_onset_other")
	public String getDateOfFirstSymptomOnsetOther() {
		return dateOfFirstSymptomOnsetOther;
	}

	@JsonProperty("date_of_first_symptom_onset_other")
	public void setDateOfFirstSymptomOnsetOther(String value) {
		this.dateOfFirstSymptomOnsetOther = value;
	}
}
