package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Cough {
	private HasContacts cough;
	private String dateCough;

	@JsonProperty("cough")
	public HasContacts getCough() {
		return cough;
	}

	@JsonProperty("cough")
	public void setCough(HasContacts value) {
		this.cough = value;
	}

	@JsonProperty("date_cough")
	public String getDateCough() {
		return dateCough;
	}

	@JsonProperty("date_cough")
	public void setDateCough(String value) {
		this.dateCough = value;
	}
}
