package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class HandledAnimals {
	private String patientHandledAnimals;

	@JsonProperty("patient_handled_animals")
	public String getPatientHandledAnimals() {
		return patientHandledAnimals;
	}

	@JsonProperty("patient_handled_animals")
	public void setPatientHandledAnimals(String value) {
		this.patientHandledAnimals = value;
	}
}
