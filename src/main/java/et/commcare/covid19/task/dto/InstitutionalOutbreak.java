package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class InstitutionalOutbreak {
	private String partOfAnInstitutionalOutbreak;

	@JsonProperty("part_of_an_institutional_outbreak")
	public String getPartOfAnInstitutionalOutbreak() {
		return partOfAnInstitutionalOutbreak;
	}

	@JsonProperty("part_of_an_institutional_outbreak")
	public void setPartOfAnInstitutionalOutbreak(String value) {
		this.partOfAnInstitutionalOutbreak = value;
	}
}
