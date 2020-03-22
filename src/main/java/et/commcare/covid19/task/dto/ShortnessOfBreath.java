package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class ShortnessOfBreath {
	private String shortnessOfBreath;

	@JsonProperty("shortness_of_breath")
	public String getShortnessOfBreath() {
		return shortnessOfBreath;
	}

	@JsonProperty("shortness_of_breath")
	public void setShortnessOfBreath(String value) {
		this.shortnessOfBreath = value;
	}
}
