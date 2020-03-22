package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class StatusOfFormCompletionStatusOfFormCompletion {
	private HasContacts formCompletedA0;
	private HasContacts formCompletedB1;
	private HasContacts formCompletedA1;

	@JsonProperty("form_completed_a0")
	public HasContacts getFormCompletedA0() {
		return formCompletedA0;
	}

	@JsonProperty("form_completed_a0")
	public void setFormCompletedA0(HasContacts value) {
		this.formCompletedA0 = value;
	}

	@JsonProperty("form_completed_b1")
	public HasContacts getFormCompletedB1() {
		return formCompletedB1;
	}

	@JsonProperty("form_completed_b1")
	public void setFormCompletedB1(HasContacts value) {
		this.formCompletedB1 = value;
	}

	@JsonProperty("form_completed_a1")
	public HasContacts getFormCompletedA1() {
		return formCompletedA1;
	}

	@JsonProperty("form_completed_a1")
	public void setFormCompletedA1(HasContacts value) {
		this.formCompletedA1 = value;
	}
}
