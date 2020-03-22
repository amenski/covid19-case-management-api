package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class FormCase {
	private String caseID;
	private String dateModified;
	private ErID userID;
	private String xmlns;
	private Create create;
	private Map<String, String> update;

	@JsonProperty("@case_id")
	public String getCaseID() {
		return caseID;
	}

	@JsonProperty("@case_id")
	public void setCaseID(String value) {
		this.caseID = value;
	}

	@JsonProperty("@date_modified")
	public String getDateModified() {
		return dateModified;
	}

	@JsonProperty("@date_modified")
	public void setDateModified(String value) {
		this.dateModified = value;
	}

	@JsonProperty("@user_id")
	public ErID getUserID() {
		return userID;
	}

	@JsonProperty("@user_id")
	public void setUserID(ErID value) {
		this.userID = value;
	}

	@JsonProperty("@xmlns")
	public String getXmlns() {
		return xmlns;
	}

	@JsonProperty("@xmlns")
	public void setXmlns(String value) {
		this.xmlns = value;
	}

	@JsonProperty("create")
	public Create getCreate() {
		return create;
	}

	@JsonProperty("create")
	public void setCreate(Create value) {
		this.create = value;
	}

	@JsonProperty("update")
	public Map<String, String> getUpdate() {
		return update;
	}

	@JsonProperty("update")
	public void setUpdate(Map<String, String> value) {
		this.update = value;
	}
}
