package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class DataCollectorInformationList {
	private String dataCollectorEmailA1;
	private String dataCollectorInstitutionA1;
	private String dataCollectorTelephoneNumberA1;
	private CommentLabel detailPrompt;
	private String formCompletionDateA1;
	private String nameOfDataCollectorA1;

	@JsonProperty("data_collector_email_a1")
	public String getDataCollectorEmailA1() {
		return dataCollectorEmailA1;
	}

	@JsonProperty("data_collector_email_a1")
	public void setDataCollectorEmailA1(String value) {
		this.dataCollectorEmailA1 = value;
	}

	@JsonProperty("data_collector_institution_a1")
	public String getDataCollectorInstitutionA1() {
		return dataCollectorInstitutionA1;
	}

	@JsonProperty("data_collector_institution_a1")
	public void setDataCollectorInstitutionA1(String value) {
		this.dataCollectorInstitutionA1 = value;
	}

	@JsonProperty("data_collector_telephone_number_a1")
	public String getDataCollectorTelephoneNumberA1() {
		return dataCollectorTelephoneNumberA1;
	}

	@JsonProperty("data_collector_telephone_number_a1")
	public void setDataCollectorTelephoneNumberA1(String value) {
		this.dataCollectorTelephoneNumberA1 = value;
	}

	@JsonProperty("detail_prompt")
	public CommentLabel getDetailPrompt() {
		return detailPrompt;
	}

	@JsonProperty("detail_prompt")
	public void setDetailPrompt(CommentLabel value) {
		this.detailPrompt = value;
	}

	@JsonProperty("form_completion_date_a1")
	public String getFormCompletionDateA1() {
		return formCompletionDateA1;
	}

	@JsonProperty("form_completion_date_a1")
	public void setFormCompletionDateA1(String value) {
		this.formCompletionDateA1 = value;
	}

	@JsonProperty("name_of_data_collector_a1")
	public String getNameOfDataCollectorA1() {
		return nameOfDataCollectorA1;
	}

	@JsonProperty("name_of_data_collector_a1")
	public void setNameOfDataCollectorA1(String value) {
		this.nameOfDataCollectorA1 = value;
	}
}
