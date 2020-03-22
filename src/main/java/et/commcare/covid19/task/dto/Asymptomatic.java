package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Asymptomatic {
	private String asymptomaticDate;
	private String asymptomaticDuration;
	private String asymptomaticSetting;
	private CommentLabel specifyCharacteristicsLabel;

	@JsonProperty("asymptomatic_date")
	public String getAsymptomaticDate() {
		return asymptomaticDate;
	}

	@JsonProperty("asymptomatic_date")
	public void setAsymptomaticDate(String value) {
		this.asymptomaticDate = value;
	}

	@JsonProperty("asymptomatic_duration")
	public String getAsymptomaticDuration() {
		return asymptomaticDuration;
	}

	@JsonProperty("asymptomatic_duration")
	public void setAsymptomaticDuration(String value) {
		this.asymptomaticDuration = value;
	}

	@JsonProperty("asymptomatic_setting")
	public String getAsymptomaticSetting() {
		return asymptomaticSetting;
	}

	@JsonProperty("asymptomatic_setting")
	public void setAsymptomaticSetting(String value) {
		this.asymptomaticSetting = value;
	}

	@JsonProperty("specify_characteristics_label")
	public CommentLabel getSpecifyCharacteristicsLabel() {
		return specifyCharacteristicsLabel;
	}

	@JsonProperty("specify_characteristics_label")
	public void setSpecifyCharacteristicsLabel(CommentLabel value) {
		this.specifyCharacteristicsLabel = value;
	}
}
