package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class RespiratorySymptoms {
	private Cough cough;
	private RunnyNose runnyNose;
	private ShortnessOfBreath shortnessOfBreath;
	private SoreThroat soreThroat;

	@JsonProperty("cough")
	public Cough getCough() {
		return cough;
	}

	@JsonProperty("cough")
	public void setCough(Cough value) {
		this.cough = value;
	}

	@JsonProperty("runny_nose")
	public RunnyNose getRunnyNose() {
		return runnyNose;
	}

	@JsonProperty("runny_nose")
	public void setRunnyNose(RunnyNose value) {
		this.runnyNose = value;
	}

	@JsonProperty("shortness_of_breath")
	public ShortnessOfBreath getShortnessOfBreath() {
		return shortnessOfBreath;
	}

	@JsonProperty("shortness_of_breath")
	public void setShortnessOfBreath(ShortnessOfBreath value) {
		this.shortnessOfBreath = value;
	}

	@JsonProperty("sore_throat")
	public SoreThroat getSoreThroat() {
		return soreThroat;
	}

	@JsonProperty("sore_throat")
	public void setSoreThroat(SoreThroat value) {
		this.soreThroat = value;
	}
}
