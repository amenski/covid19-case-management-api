package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class CardiacFailure {
	private String cardiacFailure;

	@JsonProperty("cardiac_failure")
	public String getCardiacFailure() {
		return cardiacFailure;
	}

	@JsonProperty("cardiac_failure")
	public void setCardiacFailure(String value) {
		this.cardiacFailure = value;
	}
}
