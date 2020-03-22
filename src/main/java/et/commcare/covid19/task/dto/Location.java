package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Location {
	private String areYouInTheContactsLocationAndAbleToCaptureThisPosition;

	@JsonProperty("are_you_in_the_contacts_location_and_able_to_capture_this_position")
	public String getAreYouInTheContactsLocationAndAbleToCaptureThisPosition() {
		return areYouInTheContactsLocationAndAbleToCaptureThisPosition;
	}

	@JsonProperty("are_you_in_the_contacts_location_and_able_to_capture_this_position")
	public void setAreYouInTheContactsLocationAndAbleToCaptureThisPosition(String value) {
		this.areYouInTheContactsLocationAndAbleToCaptureThisPosition = value;
	}
}
