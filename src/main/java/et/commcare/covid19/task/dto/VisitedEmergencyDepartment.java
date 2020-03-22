package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class VisitedEmergencyDepartment {
	private String additionalNotesAE;
	private String dateOfEmergencyDepartmentVisitUnknown;
	private String dateOfFirstAEContact;
	private HasContacts visitedEmergencyDepartment;

	@JsonProperty("additional_notes_ae")
	public String getAdditionalNotesAE() {
		return additionalNotesAE;
	}

	@JsonProperty("additional_notes_ae")
	public void setAdditionalNotesAE(String value) {
		this.additionalNotesAE = value;
	}

	@JsonProperty("date_of_emergency_department_visit_unknown")
	public String getDateOfEmergencyDepartmentVisitUnknown() {
		return dateOfEmergencyDepartmentVisitUnknown;
	}

	@JsonProperty("date_of_emergency_department_visit_unknown")
	public void setDateOfEmergencyDepartmentVisitUnknown(String value) {
		this.dateOfEmergencyDepartmentVisitUnknown = value;
	}

	@JsonProperty("date_of_first_ae_contact")
	public String getDateOfFirstAEContact() {
		return dateOfFirstAEContact;
	}

	@JsonProperty("date_of_first_ae_contact")
	public void setDateOfFirstAEContact(String value) {
		this.dateOfFirstAEContact = value;
	}

	@JsonProperty("visited_emergency_department")
	public HasContacts getVisitedEmergencyDepartment() {
		return visitedEmergencyDepartment;
	}

	@JsonProperty("visited_emergency_department")
	public void setVisitedEmergencyDepartment(HasContacts value) {
		this.visitedEmergencyDepartment = value;
	}
}
