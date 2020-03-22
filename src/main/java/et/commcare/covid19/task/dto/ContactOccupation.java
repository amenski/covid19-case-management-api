package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class ContactOccupation {
	private String contactOccupation;
	private String occupationLocationFacility;
	private String otherOccupation;

	@JsonProperty("contact_occupation")
	public String getContactOccupation() {
		return contactOccupation;
	}

	@JsonProperty("contact_occupation")
	public void setContactOccupation(String value) {
		this.contactOccupation = value;
	}

	@JsonProperty("occupation_location_facility")
	public String getOccupationLocationFacility() {
		return occupationLocationFacility;
	}

	@JsonProperty("occupation_location_facility")
	public void setOccupationLocationFacility(String value) {
		this.occupationLocationFacility = value;
	}

	@JsonProperty("other_occupation")
	public String getOtherOccupation() {
		return otherOccupation;
	}

	@JsonProperty("other_occupation")
	public void setOtherOccupation(String value) {
		this.otherOccupation = value;
	}
}
