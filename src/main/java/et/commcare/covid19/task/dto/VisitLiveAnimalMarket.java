package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class VisitLiveAnimalMarket {
	private String patientVisitedLiveAnimalMarket;

	@JsonProperty("patient_visited_live_animal_market")
	public String getPatientVisitedLiveAnimalMarket() {
		return patientVisitedLiveAnimalMarket;
	}

	@JsonProperty("patient_visited_live_animal_market")
	public void setPatientVisitedLiveAnimalMarket(String value) {
		this.patientVisitedLiveAnimalMarket = value;
	}
}
