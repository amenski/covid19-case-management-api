package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class VisitToPrimaryHealthcare {
	private String additionalNotesPhc;
	private String dateOfFirstPhcContact;
	private String dateOfFirstPhcContactUnknown;
	private HasContacts visitToPrimaryHealthcare;

	@JsonProperty("additional_notes_phc")
	public String getAdditionalNotesPhc() {
		return additionalNotesPhc;
	}

	@JsonProperty("additional_notes_phc")
	public void setAdditionalNotesPhc(String value) {
		this.additionalNotesPhc = value;
	}

	@JsonProperty("date_of_first_phc_contact")
	public String getDateOfFirstPhcContact() {
		return dateOfFirstPhcContact;
	}

	@JsonProperty("date_of_first_phc_contact")
	public void setDateOfFirstPhcContact(String value) {
		this.dateOfFirstPhcContact = value;
	}

	@JsonProperty("date_of_first_phc_contact_unknown")
	public String getDateOfFirstPhcContactUnknown() {
		return dateOfFirstPhcContactUnknown;
	}

	@JsonProperty("date_of_first_phc_contact_unknown")
	public void setDateOfFirstPhcContactUnknown(String value) {
		this.dateOfFirstPhcContactUnknown = value;
	}

	@JsonProperty("visit_to_primary_healthcare")
	public HasContacts getVisitToPrimaryHealthcare() {
		return visitToPrimaryHealthcare;
	}

	@JsonProperty("visit_to_primary_healthcare")
	public void setVisitToPrimaryHealthcare(HasContacts value) {
		this.visitToPrimaryHealthcare = value;
	}
}
