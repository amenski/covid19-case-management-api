package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class ContactWithEmergencyNumberHotline {
	private String additionalNotesEmergencyContact;
	private HasContacts contactWithEmergencyNumberHotline;
	private String dateOfEmergencyContact;

	@JsonProperty("additional_notes_emergency_contact")
	public String getAdditionalNotesEmergencyContact() {
		return additionalNotesEmergencyContact;
	}

	@JsonProperty("additional_notes_emergency_contact")
	public void setAdditionalNotesEmergencyContact(String value) {
		this.additionalNotesEmergencyContact = value;
	}

	@JsonProperty("contact_with_emergency_number_hotline")
	public HasContacts getContactWithEmergencyNumberHotline() {
		return contactWithEmergencyNumberHotline;
	}

	@JsonProperty("contact_with_emergency_number_hotline")
	public void setContactWithEmergencyNumberHotline(HasContacts value) {
		this.contactWithEmergencyNumberHotline = value;
	}

	@JsonProperty("date_of_emergency_contact")
	public String getDateOfEmergencyContact() {
		return dateOfEmergencyContact;
	}

	@JsonProperty("date_of_emergency_contact")
	public void setDateOfEmergencyContact(String value) {
		this.dateOfEmergencyContact = value;
	}
}
