package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class ContactDemographics {
	private String contactCountryOfResidence;
	private String contactEthnicity;
	private String contactNationalSocialNumber;
	private String contactNationality;

	@JsonProperty("contact_country_of_residence")
	public String getContactCountryOfResidence() {
		return contactCountryOfResidence;
	}

	@JsonProperty("contact_country_of_residence")
	public void setContactCountryOfResidence(String value) {
		this.contactCountryOfResidence = value;
	}

	@JsonProperty("contact_ethnicity")
	public String getContactEthnicity() {
		return contactEthnicity;
	}

	@JsonProperty("contact_ethnicity")
	public void setContactEthnicity(String value) {
		this.contactEthnicity = value;
	}

	@JsonProperty("contact_national_social_number")
	public String getContactNationalSocialNumber() {
		return contactNationalSocialNumber;
	}

	@JsonProperty("contact_national_social_number")
	public void setContactNationalSocialNumber(String value) {
		this.contactNationalSocialNumber = value;
	}

	@JsonProperty("contact_nationality")
	public String getContactNationality() {
		return contactNationality;
	}

	@JsonProperty("contact_nationality")
	public void setContactNationality(String value) {
		this.contactNationality = value;
	}
}
