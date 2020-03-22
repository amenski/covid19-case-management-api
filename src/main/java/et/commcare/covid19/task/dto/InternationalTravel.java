package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class InternationalTravel {
	private String traveledInternationally;

	@JsonProperty("traveled_internationally")
	public String getTraveledInternationally() {
		return traveledInternationally;
	}

	@JsonProperty("traveled_internationally")
	public void setTraveledInternationally(String value) {
		this.traveledInternationally = value;
	}
}
