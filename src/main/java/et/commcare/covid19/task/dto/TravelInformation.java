package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class TravelInformation {
	private DateOfLastTravel dateOfLastTravel;
	private String patientHasTraveled;
	private String travelHistory;

	@JsonProperty("date_of_last_travel")
	public DateOfLastTravel getDateOfLastTravel() {
		return dateOfLastTravel;
	}

	@JsonProperty("date_of_last_travel")
	public void setDateOfLastTravel(DateOfLastTravel value) {
		this.dateOfLastTravel = value;
	}

	@JsonProperty("patient_has_traveled")
	public String getPatientHasTraveled() {
		return patientHasTraveled;
	}

	@JsonProperty("patient_has_traveled")
	public void setPatientHasTraveled(String value) {
		this.patientHasTraveled = value;
	}

	@JsonProperty("travel_history")
	public String getTravelHistory() {
		return travelHistory;
	}

	@JsonProperty("travel_history")
	public void setTravelHistory(String value) {
		this.travelHistory = value;
	}
}
