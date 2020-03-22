package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class ConsumptiveCoagulopathy {
	private HasContacts consumptiveCoagulopathy;
	private String dateConsumptiveCoagulopathyStarted;

	@JsonProperty("consumptive_coagulopathy")
	public HasContacts getConsumptiveCoagulopathy() {
		return consumptiveCoagulopathy;
	}

	@JsonProperty("consumptive_coagulopathy")
	public void setConsumptiveCoagulopathy(HasContacts value) {
		this.consumptiveCoagulopathy = value;
	}

	@JsonProperty("date_consumptive_coagulopathy_started")
	public String getDateConsumptiveCoagulopathyStarted() {
		return dateConsumptiveCoagulopathyStarted;
	}

	@JsonProperty("date_consumptive_coagulopathy_started")
	public void setDateConsumptiveCoagulopathyStarted(String value) {
		this.dateConsumptiveCoagulopathyStarted = value;
	}
}
