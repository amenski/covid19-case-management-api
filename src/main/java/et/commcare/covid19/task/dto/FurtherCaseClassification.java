package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class FurtherCaseClassification {
	private String furtherCaseClassification;

	@JsonProperty("further_case_classification")
	public String getFurtherCaseClassification() {
		return furtherCaseClassification;
	}

	@JsonProperty("further_case_classification")
	public void setFurtherCaseClassification(String value) {
		this.furtherCaseClassification = value;
	}
}
