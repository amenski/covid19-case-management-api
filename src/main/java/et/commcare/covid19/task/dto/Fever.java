package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Fever {
	private String feverOrHistoryOfFever;

	@JsonProperty("fever_or_history_of_fever")
	public String getFeverOrHistoryOfFever() {
		return feverOrHistoryOfFever;
	}

	@JsonProperty("fever_or_history_of_fever")
	public void setFeverOrHistoryOfFever(String value) {
		this.feverOrHistoryOfFever = value;
	}
}
