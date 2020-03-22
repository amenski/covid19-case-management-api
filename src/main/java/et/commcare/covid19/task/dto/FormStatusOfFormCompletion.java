package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class FormStatusOfFormCompletion {
	private StatusOfFormCompletionStatusOfFormCompletion statusOfFormCompletion;

	@JsonProperty("status_of_form_completion")
	public StatusOfFormCompletionStatusOfFormCompletion getStatusOfFormCompletion() {
		return statusOfFormCompletion;
	}

	@JsonProperty("status_of_form_completion")
	public void setStatusOfFormCompletion(StatusOfFormCompletionStatusOfFormCompletion value) {
		this.statusOfFormCompletion = value;
	}
}
