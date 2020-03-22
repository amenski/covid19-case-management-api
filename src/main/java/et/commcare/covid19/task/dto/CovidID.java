package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class CovidID {
	private String autoUid;
	private CommentLabel autoUidLabel;
	private ManualOrAuto manualOrAuto;
	private String uniqueCaseID;

	@JsonProperty("auto_uid")
	public String getAutoUid() {
		return autoUid;
	}

	@JsonProperty("auto_uid")
	public void setAutoUid(String value) {
		this.autoUid = value;
	}

	@JsonProperty("auto_uid_label")
	public CommentLabel getAutoUidLabel() {
		return autoUidLabel;
	}

	@JsonProperty("auto_uid_label")
	public void setAutoUidLabel(CommentLabel value) {
		this.autoUidLabel = value;
	}

	@JsonProperty("manual_or_auto")
	public ManualOrAuto getManualOrAuto() {
		return manualOrAuto;
	}

	@JsonProperty("manual_or_auto")
	public void setManualOrAuto(ManualOrAuto value) {
		this.manualOrAuto = value;
	}

	@JsonProperty("unique_case_id")
	public String getUniqueCaseID() {
		return uniqueCaseID;
	}

	@JsonProperty("unique_case_id")
	public void setUniqueCaseID(String value) {
		this.uniqueCaseID = value;
	}
}
