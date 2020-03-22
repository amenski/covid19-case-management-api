package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class OtherComplications {
	private String otherComplications;

	@JsonProperty("other_complications")
	public String getOtherComplications() {
		return otherComplications;
	}

	@JsonProperty("other_complications")
	public void setOtherComplications(String value) {
		this.otherComplications = value;
	}
}
