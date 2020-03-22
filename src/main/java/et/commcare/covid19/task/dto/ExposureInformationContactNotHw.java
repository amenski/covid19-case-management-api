package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class ExposureInformationContactNotHw {
	private Asymptomatic asymptomatic;
	private Symptomatic symptomatic;
	private TypeOfContact typeOfContact;

	@JsonProperty("asymptomatic")
	public Asymptomatic getAsymptomatic() {
		return asymptomatic;
	}

	@JsonProperty("asymptomatic")
	public void setAsymptomatic(Asymptomatic value) {
		this.asymptomatic = value;
	}

	@JsonProperty("symptomatic")
	public Symptomatic getSymptomatic() {
		return symptomatic;
	}

	@JsonProperty("symptomatic")
	public void setSymptomatic(Symptomatic value) {
		this.symptomatic = value;
	}

	@JsonProperty("type_of_contact")
	public TypeOfContact getTypeOfContact() {
		return typeOfContact;
	}

	@JsonProperty("type_of_contact")
	public void setTypeOfContact(TypeOfContact value) {
		this.typeOfContact = value;
	}
}
