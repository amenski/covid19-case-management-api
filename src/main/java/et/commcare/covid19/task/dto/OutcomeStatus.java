package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class OutcomeStatus {
	private String hospitalizationEverRequired;
	private Status status;

	@JsonProperty("hospitalization_ever_required")
	public String getHospitalizationEverRequired() {
		return hospitalizationEverRequired;
	}

	@JsonProperty("hospitalization_ever_required")
	public void setHospitalizationEverRequired(String value) {
		this.hospitalizationEverRequired = value;
	}

	@JsonProperty("status")
	public Status getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(Status value) {
		this.status = value;
	}
}
