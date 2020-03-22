package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class TypeOfContact {
	private String typeOfContact;

	@JsonProperty("type_of_contact")
	public String getTypeOfContact() {
		return typeOfContact;
	}

	@JsonProperty("type_of_contact")
	public void setTypeOfContact(String value) {
		this.typeOfContact = value;
	}
}
