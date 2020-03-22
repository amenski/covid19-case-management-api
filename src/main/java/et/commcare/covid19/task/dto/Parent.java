package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Parent {
	private String text;
	private CaseType caseType;

	@JsonProperty("#text")
	public String getText() {
		return text;
	}

	@JsonProperty("#text")
	public void setText(String value) {
		this.text = value;
	}

	@JsonProperty("@case_type")
	public CaseType getCaseType() {
		return caseType;
	}

	@JsonProperty("@case_type")
	public void setCaseType(CaseType value) {
		this.caseType = value;
	}
}
