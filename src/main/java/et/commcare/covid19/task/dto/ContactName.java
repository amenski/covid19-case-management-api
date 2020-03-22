package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class ContactName {
	private String contactFamilyName;
	private String contactFirstName;

	@JsonProperty("contact_family_name")
	public String getContactFamilyName() {
		return contactFamilyName;
	}

	@JsonProperty("contact_family_name")
	public void setContactFamilyName(String value) {
		this.contactFamilyName = value;
	}

	@JsonProperty("contact_first_name")
	public String getContactFirstName() {
		return contactFirstName;
	}

	@JsonProperty("contact_first_name")
	public void setContactFirstName(String value) {
		this.contactFirstName = value;
	}
}
