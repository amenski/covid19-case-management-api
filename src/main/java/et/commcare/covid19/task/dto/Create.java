package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Create {
	private String caseName;
	private CaseType caseType;
	private ErID ownerID;

	@JsonProperty("case_name")
	public String getCaseName() {
		return caseName;
	}

	@JsonProperty("case_name")
	public void setCaseName(String value) {
		this.caseName = value;
	}

	@JsonProperty("case_type")
	public CaseType getCaseType() {
		return caseType;
	}

	@JsonProperty("case_type")
	public void setCaseType(CaseType value) {
		this.caseType = value;
	}

	@JsonProperty("owner_id")
	public ErID getOwnerID() {
		return ownerID;
	}

	@JsonProperty("owner_id")
	public void setOwnerID(ErID value) {
		this.ownerID = value;
	}
}
