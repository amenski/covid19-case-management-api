package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class HealthCareCentreTreatingPhysicianDetails {
	private String healthCentreAddress;
	private String healthCentreFax;
	private String healthCentreTelephoneNumber;
	private InstitutionalOutbreak institutionalOutbreak;
	private String nameOfHealthCareCentre;
	private String nameOfTreatingPhysician;

	@JsonProperty("health_centre_address")
	public String getHealthCentreAddress() {
		return healthCentreAddress;
	}

	@JsonProperty("health_centre_address")
	public void setHealthCentreAddress(String value) {
		this.healthCentreAddress = value;
	}

	@JsonProperty("health_centre_fax")
	public String getHealthCentreFax() {
		return healthCentreFax;
	}

	@JsonProperty("health_centre_fax")
	public void setHealthCentreFax(String value) {
		this.healthCentreFax = value;
	}

	@JsonProperty("health_centre_telephone_number")
	public String getHealthCentreTelephoneNumber() {
		return healthCentreTelephoneNumber;
	}

	@JsonProperty("health_centre_telephone_number")
	public void setHealthCentreTelephoneNumber(String value) {
		this.healthCentreTelephoneNumber = value;
	}

	@JsonProperty("institutional_outbreak")
	public InstitutionalOutbreak getInstitutionalOutbreak() {
		return institutionalOutbreak;
	}

	@JsonProperty("institutional_outbreak")
	public void setInstitutionalOutbreak(InstitutionalOutbreak value) {
		this.institutionalOutbreak = value;
	}

	@JsonProperty("name_of_health-care_centre")
	public String getNameOfHealthCareCentre() {
		return nameOfHealthCareCentre;
	}

	@JsonProperty("name_of_health-care_centre")
	public void setNameOfHealthCareCentre(String value) {
		this.nameOfHealthCareCentre = value;
	}

	@JsonProperty("name_of_treating_physician")
	public String getNameOfTreatingPhysician() {
		return nameOfTreatingPhysician;
	}

	@JsonProperty("name_of_treating_physician")
	public void setNameOfTreatingPhysician(String value) {
		this.nameOfTreatingPhysician = value;
	}
}
