package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class GeneralExposureInformationContactWithConfirmedCase {
	private String contactSuspectedOrConfirmed;

	@JsonProperty("contact_suspected_or_confirmed")
	public String getContactSuspectedOrConfirmed() {
		return contactSuspectedOrConfirmed;
	}

	@JsonProperty("contact_suspected_or_confirmed")
	public void setContactSuspectedOrConfirmed(String value) {
		this.contactSuspectedOrConfirmed = value;
	}
}
