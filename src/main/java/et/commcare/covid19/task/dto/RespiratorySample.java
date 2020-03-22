package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class RespiratorySample {
	private String otherRespiratorySample;
	private String typeOfRespiratorySample;

	@JsonProperty("other_respiratory_sample")
	public String getOtherRespiratorySample() {
		return otherRespiratorySample;
	}

	@JsonProperty("other_respiratory_sample")
	public void setOtherRespiratorySample(String value) {
		this.otherRespiratorySample = value;
	}

	@JsonProperty("type_of_respiratory_sample")
	public String getTypeOfRespiratorySample() {
		return typeOfRespiratorySample;
	}

	@JsonProperty("type_of_respiratory_sample")
	public void setTypeOfRespiratorySample(String value) {
		this.typeOfRespiratorySample = value;
	}
}
