package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class MechanicalVentilation {
	private String lengthOfVentilationCalc;
	private String mechanicalVentilation;

	@JsonProperty("length_of_ventilation_calc")
	public String getLengthOfVentilationCalc() {
		return lengthOfVentilationCalc;
	}

	@JsonProperty("length_of_ventilation_calc")
	public void setLengthOfVentilationCalc(String value) {
		this.lengthOfVentilationCalc = value;
	}

	@JsonProperty("mechanical_ventilation")
	public String getMechanicalVentilation() {
		return mechanicalVentilation;
	}

	@JsonProperty("mechanical_ventilation")
	public void setMechanicalVentilation(String value) {
		this.mechanicalVentilation = value;
	}
}
