package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class HealthCareInteractions {
	private ContactWithEmergencyNumberHotline contactWithEmergencyNumberHotline;
	private HealthCareInteractionsHospitalization hospitalization;
	private VisitToPrimaryHealthcare visitToPrimaryHealthcare;
	private VisitedEmergencyDepartment visitedEmergencyDepartment;

	@JsonProperty("contact_with_emergency_number_hotline")
	public ContactWithEmergencyNumberHotline getContactWithEmergencyNumberHotline() {
		return contactWithEmergencyNumberHotline;
	}

	@JsonProperty("contact_with_emergency_number_hotline")
	public void setContactWithEmergencyNumberHotline(ContactWithEmergencyNumberHotline value) {
		this.contactWithEmergencyNumberHotline = value;
	}

	@JsonProperty("hospitalization")
	public HealthCareInteractionsHospitalization getHospitalization() {
		return hospitalization;
	}

	@JsonProperty("hospitalization")
	public void setHospitalization(HealthCareInteractionsHospitalization value) {
		this.hospitalization = value;
	}

	@JsonProperty("visit_to_primary_healthcare")
	public VisitToPrimaryHealthcare getVisitToPrimaryHealthcare() {
		return visitToPrimaryHealthcare;
	}

	@JsonProperty("visit_to_primary_healthcare")
	public void setVisitToPrimaryHealthcare(VisitToPrimaryHealthcare value) {
		this.visitToPrimaryHealthcare = value;
	}

	@JsonProperty("visited_emergency_department")
	public VisitedEmergencyDepartment getVisitedEmergencyDepartment() {
		return visitedEmergencyDepartment;
	}

	@JsonProperty("visited_emergency_department")
	public void setVisitedEmergencyDepartment(VisitedEmergencyDepartment value) {
		this.visitedEmergencyDepartment = value;
	}
}
