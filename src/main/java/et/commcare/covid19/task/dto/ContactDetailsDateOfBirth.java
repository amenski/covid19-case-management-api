package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class ContactDetailsDateOfBirth {
	private String contactDateOfBirth;
	private String contactDateOfBirthUnknown;

	@JsonProperty("contact_date_of_birth")
	public String getContactDateOfBirth() {
		return contactDateOfBirth;
	}

	@JsonProperty("contact_date_of_birth")
	public void setContactDateOfBirth(String value) {
		this.contactDateOfBirth = value;
	}

	@JsonProperty("contact_date_of_birth_unknown")
	public String getContactDateOfBirthUnknown() {
		return contactDateOfBirthUnknown;
	}

	@JsonProperty("contact_date_of_birth_unknown")
	public void setContactDateOfBirthUnknown(String value) {
		this.contactDateOfBirthUnknown = value;
	}
}
