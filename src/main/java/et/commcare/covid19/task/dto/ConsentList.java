package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class ConsentList {
	private HasContacts consentConfirmation;

	@JsonProperty("consent_confirmation")
	public HasContacts getConsentConfirmation() {
		return consentConfirmation;
	}

	@JsonProperty("consent_confirmation")
	public void setConsentConfirmation(HasContacts value) {
		this.consentConfirmation = value;
	}
}
