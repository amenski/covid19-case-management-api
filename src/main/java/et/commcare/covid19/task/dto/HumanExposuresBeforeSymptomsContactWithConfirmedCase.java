package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class HumanExposuresBeforeSymptomsContactWithConfirmedCase {
	private String contactSuspectedOrConfirmed;
	private String nameOfContactedSuspectAo;
	private String phoneNumberOfContactedSuspectAo;
	private String dateOfLastContact;

	@JsonProperty("contact_suspected_or_confirmed")
	public String getContactSuspectedOrConfirmed() {
		return contactSuspectedOrConfirmed;
	}

	@JsonProperty("contact_suspected_or_confirmed")
	public void setContactSuspectedOrConfirmed(String value) {
		this.contactSuspectedOrConfirmed = value;
	}

	@JsonProperty("name_of_contacted_suspect_ao")
	public String getNameOfContactedSuspectAo() {
		return nameOfContactedSuspectAo;
	}

	@JsonProperty("name_of_contacted_suspect_ao")
	public void setNameOfContactedSuspectAo(String value) {
		this.nameOfContactedSuspectAo = value;
	}

	@JsonProperty("phone_number_of_contacted_suspect_ao")
	public String getPhoneNumberOfContactedSuspectAo() {
		return phoneNumberOfContactedSuspectAo;
	}

	@JsonProperty("phone_number_of_contacted_suspect_ao")
	public void setPhoneNumberOfContactedSuspectAo(String value) {
		this.phoneNumberOfContactedSuspectAo = value;
	}

	@JsonProperty("date_of_last_contact")
	public String getDateOfLastContact() {
		return dateOfLastContact;
	}

	@JsonProperty("date_of_last_contact")
	public void setDateOfLastContact(String value) {
		this.dateOfLastContact = value;
	}
}
