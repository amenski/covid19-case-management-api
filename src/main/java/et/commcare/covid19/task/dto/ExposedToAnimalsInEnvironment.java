package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class ExposedToAnimalsInEnvironment {
	private String patientExposedToAnimalsInTheEnvironment;

	@JsonProperty("patient_exposed_to_animals_in_the_environment")
	public String getPatientExposedToAnimalsInTheEnvironment() {
		return patientExposedToAnimalsInTheEnvironment;
	}

	@JsonProperty("patient_exposed_to_animals_in_the_environment")
	public void setPatientExposedToAnimalsInTheEnvironment(String value) {
		this.patientExposedToAnimalsInTheEnvironment = value;
	}
}
