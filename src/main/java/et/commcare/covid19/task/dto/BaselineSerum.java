package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class BaselineSerum {
	private String baselineSerumTaken;

	@JsonProperty("baseline_serum_taken")
	public String getBaselineSerumTaken() {
		return baselineSerumTaken;
	}

	@JsonProperty("baseline_serum_taken")
	public void setBaselineSerumTaken(String value) {
		this.baselineSerumTaken = value;
	}
}
