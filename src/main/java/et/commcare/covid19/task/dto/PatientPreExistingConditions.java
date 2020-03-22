package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class PatientPreExistingConditions {
	private TPreExistingConditions patientPreExistingConditions;

	@JsonProperty("patient_pre-existing_conditions")
	public TPreExistingConditions getPatientPreExistingConditions() {
		return patientPreExistingConditions;
	}

	@JsonProperty("patient_pre-existing_conditions")
	public void setPatientPreExistingConditions(TPreExistingConditions value) {
		this.patientPreExistingConditions = value;
	}
}
