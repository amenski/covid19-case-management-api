package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class AcuteRenalFailure {
	private String acuteRenalFailure;

	@JsonProperty("acute_renal_failure")
	public String getAcuteRenalFailure() {
		return acuteRenalFailure;
	}

	@JsonProperty("acute_renal_failure")
	public void setAcuteRenalFailure(String value) {
		this.acuteRenalFailure = value;
	}
}
