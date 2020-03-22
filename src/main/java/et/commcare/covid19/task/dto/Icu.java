package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Icu {
	private String icuAdmission;

	@JsonProperty("icu_admission")
	public String getIcuAdmission() {
		return icuAdmission;
	}

	@JsonProperty("icu_admission")
	public void setIcuAdmission(String value) {
		this.icuAdmission = value;
	}
}
