package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class SoreThroat {
	private String dateSoreThroat;
	private HasContacts soreThroat;

	@JsonProperty("date_sore_throat")
	public String getDateSoreThroat() {
		return dateSoreThroat;
	}

	@JsonProperty("date_sore_throat")
	public void setDateSoreThroat(String value) {
		this.dateSoreThroat = value;
	}

	@JsonProperty("sore_throat")
	public HasContacts getSoreThroat() {
		return soreThroat;
	}

	@JsonProperty("sore_throat")
	public void setSoreThroat(HasContacts value) {
		this.soreThroat = value;
	}
}
