package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class ContactPreExistingConditions {
	private TPreExistingConditions contactPreExistingConditions;

	@JsonProperty("contact_pre-existing_conditions")
	public TPreExistingConditions getContactPreExistingConditions() {
		return contactPreExistingConditions;
	}

	@JsonProperty("contact_pre-existing_conditions")
	public void setContactPreExistingConditions(TPreExistingConditions value) {
		this.contactPreExistingConditions = value;
	}
}
