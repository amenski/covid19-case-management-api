package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class DomesticTravel {
	private String traveledDomestically;

	@JsonProperty("traveled_domestically")
	public String getTraveledDomestically() {
		return traveledDomestically;
	}

	@JsonProperty("traveled_domestically")
	public void setTraveledDomestically(String value) {
		this.traveledDomestically = value;
	}
}
