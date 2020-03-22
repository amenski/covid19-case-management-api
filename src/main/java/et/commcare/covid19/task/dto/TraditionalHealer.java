package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class TraditionalHealer {
	private String visitedTraditionalHealer;
	private String traditionalHealerType;

	@JsonProperty("visited_traditional_healer")
	public String getVisitedTraditionalHealer() {
		return visitedTraditionalHealer;
	}

	@JsonProperty("visited_traditional_healer")
	public void setVisitedTraditionalHealer(String value) {
		this.visitedTraditionalHealer = value;
	}

	@JsonProperty("traditional_healer_type")
	public String getTraditionalHealerType() {
		return traditionalHealerType;
	}

	@JsonProperty("traditional_healer_type")
	public void setTraditionalHealerType(String value) {
		this.traditionalHealerType = value;
	}
}
