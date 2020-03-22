package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class PatientSymptomsComplicationsHospitalization {
	private String dateOfFirstHospitalization;
	private String dateOfFirstHospitalizationUnknown;
	private HasContacts hospitalization;

	@JsonProperty("date_of_first_hospitalization")
	public String getDateOfFirstHospitalization() {
		return dateOfFirstHospitalization;
	}

	@JsonProperty("date_of_first_hospitalization")
	public void setDateOfFirstHospitalization(String value) {
		this.dateOfFirstHospitalization = value;
	}

	@JsonProperty("date_of_first_hospitalization_unknown")
	public String getDateOfFirstHospitalizationUnknown() {
		return dateOfFirstHospitalizationUnknown;
	}

	@JsonProperty("date_of_first_hospitalization_unknown")
	public void setDateOfFirstHospitalizationUnknown(String value) {
		this.dateOfFirstHospitalizationUnknown = value;
	}

	@JsonProperty("hospitalization")
	public HasContacts getHospitalization() {
		return hospitalization;
	}

	@JsonProperty("hospitalization")
	public void setHospitalization(HasContacts value) {
		this.hospitalization = value;
	}
}
