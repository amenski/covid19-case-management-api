package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class FormOtherSymptoms {
	private OtherSymptomsOtherSymptoms otherSymptoms;

	@JsonProperty("other_symptoms")
	public OtherSymptomsOtherSymptoms getOtherSymptoms() {
		return otherSymptoms;
	}

	@JsonProperty("other_symptoms")
	public void setOtherSymptoms(OtherSymptomsOtherSymptoms value) {
		this.otherSymptoms = value;
	}
}
