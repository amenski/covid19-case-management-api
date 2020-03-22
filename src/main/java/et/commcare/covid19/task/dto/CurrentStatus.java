package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class CurrentStatus {
	private String residency;

	@JsonProperty("Residency")
	public String getResidency() {
		return residency;
	}

	@JsonProperty("Residency")
	public void setResidency(String value) {
		this.residency = value;
	}
}
