package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class HospitalizationRequired {
	private HasContacts hospitalizationRequired;
	private String nameOfHospital;

	@JsonProperty("hospitalization_required")
	public HasContacts getHospitalizationRequired() {
		return hospitalizationRequired;
	}

	@JsonProperty("hospitalization_required")
	public void setHospitalizationRequired(HasContacts value) {
		this.hospitalizationRequired = value;
	}

	@JsonProperty("name_of_hospital")
	public String getNameOfHospital() {
		return nameOfHospital;
	}

	@JsonProperty("name_of_hospital")
	public void setNameOfHospital(String value) {
		this.nameOfHospital = value;
	}
}
