package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class DateOfDischarge {
	private String dateOfDischargeFromHospital;
	private String dateOfDischargeFromHospitalNa;

	@JsonProperty("date_of_discharge_from_hospital")
	public String getDateOfDischargeFromHospital() {
		return dateOfDischargeFromHospital;
	}

	@JsonProperty("date_of_discharge_from_hospital")
	public void setDateOfDischargeFromHospital(String value) {
		this.dateOfDischargeFromHospital = value;
	}

	@JsonProperty("date_of_discharge_from_hospital_na")
	public String getDateOfDischargeFromHospitalNa() {
		return dateOfDischargeFromHospitalNa;
	}

	@JsonProperty("date_of_discharge_from_hospital_na")
	public void setDateOfDischargeFromHospitalNa(String value) {
		this.dateOfDischargeFromHospitalNa = value;
	}
}
