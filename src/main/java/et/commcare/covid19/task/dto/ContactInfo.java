package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class ContactInfo {
	private String contactAddress;
	private String contactEmail;
	private String contactModeOfContact;
	private String contactTelephoneMobileNumber;

	@JsonProperty("contact_address")
	public String getContactAddress() {
		return contactAddress;
	}

	@JsonProperty("contact_address")
	public void setContactAddress(String value) {
		this.contactAddress = value;
	}

	@JsonProperty("contact_email")
	public String getContactEmail() {
		return contactEmail;
	}

	@JsonProperty("contact_email")
	public void setContactEmail(String value) {
		this.contactEmail = value;
	}

	@JsonProperty("contact_mode_of_contact")
	public String getContactModeOfContact() {
		return contactModeOfContact;
	}

	@JsonProperty("contact_mode_of_contact")
	public void setContactModeOfContact(String value) {
		this.contactModeOfContact = value;
	}

	@JsonProperty("contact_telephone_mobile_number")
	public String getContactTelephoneMobileNumber() {
		return contactTelephoneMobileNumber;
	}

	@JsonProperty("contact_telephone_mobile_number")
	public void setContactTelephoneMobileNumber(String value) {
		this.contactTelephoneMobileNumber = value;
	}
}
