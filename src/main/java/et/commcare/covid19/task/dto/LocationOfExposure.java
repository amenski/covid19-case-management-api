package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class LocationOfExposure {
	private String locationOfExposure;
	private String otherLocationOfExposure;

	@JsonProperty("location_of_exposure")
	public String getLocationOfExposure() {
		return locationOfExposure;
	}

	@JsonProperty("location_of_exposure")
	public void setLocationOfExposure(String value) {
		this.locationOfExposure = value;
	}

	@JsonProperty("other_location_of_exposure")
	public String getOtherLocationOfExposure() {
		return otherLocationOfExposure;
	}

	@JsonProperty("other_location_of_exposure")
	public void setOtherLocationOfExposure(String value) {
		this.otherLocationOfExposure = value;
	}
}
