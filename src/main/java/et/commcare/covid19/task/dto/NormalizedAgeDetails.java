package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class NormalizedAgeDetails {
	private String ageInMonths;
	private String ageInYears;

	@JsonProperty("age_in_months")
	public String getAgeInMonths() {
		return ageInMonths;
	}

	@JsonProperty("age_in_months")
	public void setAgeInMonths(String value) {
		this.ageInMonths = value;
	}

	@JsonProperty("age_in_years")
	public String getAgeInYears() {
		return ageInYears;
	}

	@JsonProperty("age_in_years")
	public void setAgeInYears(String value) {
		this.ageInYears = value;
	}
}
