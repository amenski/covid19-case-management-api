package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class OtherSamples {
	private String dateOtherSamplesTaken;
	private String otherSamplesCollected;
	private String whichSamples;

	@JsonProperty("date_other_samples_taken")
	public String getDateOtherSamplesTaken() {
		return dateOtherSamplesTaken;
	}

	@JsonProperty("date_other_samples_taken")
	public void setDateOtherSamplesTaken(String value) {
		this.dateOtherSamplesTaken = value;
	}

	@JsonProperty("other_samples_collected")
	public String getOtherSamplesCollected() {
		return otherSamplesCollected;
	}

	@JsonProperty("other_samples_collected")
	public void setOtherSamplesCollected(String value) {
		this.otherSamplesCollected = value;
	}

	@JsonProperty("which_samples")
	public String getWhichSamples() {
		return whichSamples;
	}

	@JsonProperty("which_samples")
	public void setWhichSamples(String value) {
		this.whichSamples = value;
	}
}
