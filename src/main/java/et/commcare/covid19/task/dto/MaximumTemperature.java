package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class MaximumTemperature {
	private String maxTempC;
	private String temperatureNa;

	@JsonProperty("max_temp_c")
	public String getMaxTempC() {
		return maxTempC;
	}

	@JsonProperty("max_temp_c")
	public void setMaxTempC(String value) {
		this.maxTempC = value;
	}

	@JsonProperty("temperature_na")
	public String getTemperatureNa() {
		return temperatureNa;
	}

	@JsonProperty("temperature_na")
	public void setTemperatureNa(String value) {
		this.temperatureNa = value;
	}
}
