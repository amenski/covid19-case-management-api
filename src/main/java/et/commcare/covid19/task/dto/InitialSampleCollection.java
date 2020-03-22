package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class InitialSampleCollection {
	private BaselineSerum baselineSerum;
	private String dateRespiratorySampleCollected;
	private OtherSamples otherSamples;
	private RespiratorySample respiratorySample;

	@JsonProperty("baseline_serum")
	public BaselineSerum getBaselineSerum() {
		return baselineSerum;
	}

	@JsonProperty("baseline_serum")
	public void setBaselineSerum(BaselineSerum value) {
		this.baselineSerum = value;
	}

	@JsonProperty("date_respiratory_sample_collected")
	public String getDateRespiratorySampleCollected() {
		return dateRespiratorySampleCollected;
	}

	@JsonProperty("date_respiratory_sample_collected")
	public void setDateRespiratorySampleCollected(String value) {
		this.dateRespiratorySampleCollected = value;
	}

	@JsonProperty("other_samples")
	public OtherSamples getOtherSamples() {
		return otherSamples;
	}

	@JsonProperty("other_samples")
	public void setOtherSamples(OtherSamples value) {
		this.otherSamples = value;
	}

	@JsonProperty("respiratory_sample")
	public RespiratorySample getRespiratorySample() {
		return respiratorySample;
	}

	@JsonProperty("respiratory_sample")
	public void setRespiratorySample(RespiratorySample value) {
		this.respiratorySample = value;
	}
}
