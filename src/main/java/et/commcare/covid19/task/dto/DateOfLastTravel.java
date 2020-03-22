package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class DateOfLastTravel {
	private String ifPatientHasTraveledDateOfLastTrip;
	private String travelHistory;

	@JsonProperty("if_patient_has_traveled_date_of_last_trip")
	public String getIfPatientHasTraveledDateOfLastTrip() {
		return ifPatientHasTraveledDateOfLastTrip;
	}

	@JsonProperty("if_patient_has_traveled_date_of_last_trip")
	public void setIfPatientHasTraveledDateOfLastTrip(String value) {
		this.ifPatientHasTraveledDateOfLastTrip = value;
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
