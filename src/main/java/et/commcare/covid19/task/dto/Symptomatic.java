package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Symptomatic {
	private CommentLabel specifyCharacteristicsLabel;
	private String symptomaticDate;
	private String symptomaticDuration;
	private String symptomaticSetting;

	@JsonProperty("specify_characteristics_label")
	public CommentLabel getSpecifyCharacteristicsLabel() {
		return specifyCharacteristicsLabel;
	}

	@JsonProperty("specify_characteristics_label")
	public void setSpecifyCharacteristicsLabel(CommentLabel value) {
		this.specifyCharacteristicsLabel = value;
	}

	@JsonProperty("symptomatic_date")
	public String getSymptomaticDate() {
		return symptomaticDate;
	}

	@JsonProperty("symptomatic_date")
	public void setSymptomaticDate(String value) {
		this.symptomaticDate = value;
	}

	@JsonProperty("symptomatic_duration")
	public String getSymptomaticDuration() {
		return symptomaticDuration;
	}

	@JsonProperty("symptomatic_duration")
	public void setSymptomaticDuration(String value) {
		this.symptomaticDuration = value;
	}

	@JsonProperty("symptomatic_setting")
	public String getSymptomaticSetting() {
		return symptomaticSetting;
	}

	@JsonProperty("symptomatic_setting")
	public void setSymptomaticSetting(String value) {
		this.symptomaticSetting = value;
	}
}
