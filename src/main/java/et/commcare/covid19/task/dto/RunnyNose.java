package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class RunnyNose {
	private String runnyNose;
	private String dateRunnyNose;

	@JsonProperty("runny_nose")
	public String getRunnyNose() {
		return runnyNose;
	}

	@JsonProperty("runny_nose")
	public void setRunnyNose(String value) {
		this.runnyNose = value;
	}

	@JsonProperty("date_runny_nose")
	public String getDateRunnyNose() {
		return dateRunnyNose;
	}

	@JsonProperty("date_runny_nose")
	public void setDateRunnyNose(String value) {
		this.dateRunnyNose = value;
	}
}
