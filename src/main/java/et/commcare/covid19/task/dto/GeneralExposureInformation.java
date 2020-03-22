package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class GeneralExposureInformation {
	private ContactOccupation contactOccupation;
	private GeneralExposureInformationContactWithConfirmedCase contactWithConfirmedCase;
	private DomesticTravel domesticTravel;
	private InternationalTravel internationalTravel;

	@JsonProperty("contact_occupation")
	public ContactOccupation getContactOccupation() {
		return contactOccupation;
	}

	@JsonProperty("contact_occupation")
	public void setContactOccupation(ContactOccupation value) {
		this.contactOccupation = value;
	}

	@JsonProperty("contact_with_confirmed_case")
	public GeneralExposureInformationContactWithConfirmedCase getContactWithConfirmedCase() {
		return contactWithConfirmedCase;
	}

	@JsonProperty("contact_with_confirmed_case")
	public void setContactWithConfirmedCase(GeneralExposureInformationContactWithConfirmedCase value) {
		this.contactWithConfirmedCase = value;
	}

	@JsonProperty("domestic_travel")
	public DomesticTravel getDomesticTravel() {
		return domesticTravel;
	}

	@JsonProperty("domestic_travel")
	public void setDomesticTravel(DomesticTravel value) {
		this.domesticTravel = value;
	}

	@JsonProperty("international_travel")
	public InternationalTravel getInternationalTravel() {
		return internationalTravel;
	}

	@JsonProperty("international_travel")
	public void setInternationalTravel(InternationalTravel value) {
		this.internationalTravel = value;
	}
}
