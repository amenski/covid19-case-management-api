package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class ContactDetails {
	private ContactDemographics contactDemographics;
	private ContactInfo contactInfo;
	private ContactName contactName;
	private String contactNameLastFirst;
	private String contactRelationshipToCase;
	private String contactSex;
	private ContactDetailsDateOfBirth dateOfBirth;
	private Location location;

	@JsonProperty("contact_demographics")
	public ContactDemographics getContactDemographics() {
		return contactDemographics;
	}

	@JsonProperty("contact_demographics")
	public void setContactDemographics(ContactDemographics value) {
		this.contactDemographics = value;
	}

	@JsonProperty("contact_info")
	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	@JsonProperty("contact_info")
	public void setContactInfo(ContactInfo value) {
		this.contactInfo = value;
	}

	@JsonProperty("contact_name")
	public ContactName getContactName() {
		return contactName;
	}

	@JsonProperty("contact_name")
	public void setContactName(ContactName value) {
		this.contactName = value;
	}

	@JsonProperty("contact_name_last_first")
	public String getContactNameLastFirst() {
		return contactNameLastFirst;
	}

	@JsonProperty("contact_name_last_first")
	public void setContactNameLastFirst(String value) {
		this.contactNameLastFirst = value;
	}

	@JsonProperty("contact_relationship_to_case")
	public String getContactRelationshipToCase() {
		return contactRelationshipToCase;
	}

	@JsonProperty("contact_relationship_to_case")
	public void setContactRelationshipToCase(String value) {
		this.contactRelationshipToCase = value;
	}

	@JsonProperty("contact_sex")
	public String getContactSex() {
		return contactSex;
	}

	@JsonProperty("contact_sex")
	public void setContactSex(String value) {
		this.contactSex = value;
	}

	@JsonProperty("date_of_birth")
	public ContactDetailsDateOfBirth getDateOfBirth() {
		return dateOfBirth;
	}

	@JsonProperty("date_of_birth")
	public void setDateOfBirth(ContactDetailsDateOfBirth value) {
		this.dateOfBirth = value;
	}

	@JsonProperty("location")
	public Location getLocation() {
		return location;
	}

	@JsonProperty("location")
	public void setLocation(Location value) {
		this.location = value;
	}
}
