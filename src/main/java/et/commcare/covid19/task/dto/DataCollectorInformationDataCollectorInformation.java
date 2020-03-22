package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class DataCollectorInformationDataCollectorInformation {
	private String dataCollectorEmailA0;
	private String dataCollectorInstitutionA0;
	private String dataCollectorTelephoneNumberA0;
	private String detailPrompt;
	private String formCompletionDateA0;
	private String nameOfDataCollectorA0;
	private String dataCollectorEmailB1;
	private String dataCollectorInstitutionB1;
	private String dataCollectorTelephoneNumberB1;
	private String formCompletionDateB1;
	private String nameOfDataCollectorB1;

	@JsonProperty("data_collector_email_a0")
	public String getDataCollectorEmailA0() {
		return dataCollectorEmailA0;
	}

	@JsonProperty("data_collector_email_a0")
	public void setDataCollectorEmailA0(String value) {
		this.dataCollectorEmailA0 = value;
	}

	@JsonProperty("data_collector_institution_a0")
	public String getDataCollectorInstitutionA0() {
		return dataCollectorInstitutionA0;
	}

	@JsonProperty("data_collector_institution_a0")
	public void setDataCollectorInstitutionA0(String value) {
		this.dataCollectorInstitutionA0 = value;
	}

	@JsonProperty("data_collector_telephone_number_a0")
	public String getDataCollectorTelephoneNumberA0() {
		return dataCollectorTelephoneNumberA0;
	}

	@JsonProperty("data_collector_telephone_number_a0")
	public void setDataCollectorTelephoneNumberA0(String value) {
		this.dataCollectorTelephoneNumberA0 = value;
	}

	@JsonProperty("detail_prompt")
	public String getDetailPrompt() {
		return detailPrompt;
	}

	@JsonProperty("detail_prompt")
	public void setDetailPrompt(String value) {
		this.detailPrompt = value;
	}

	@JsonProperty("form_completion_date_a0")
	public String getFormCompletionDateA0() {
		return formCompletionDateA0;
	}

	@JsonProperty("form_completion_date_a0")
	public void setFormCompletionDateA0(String value) {
		this.formCompletionDateA0 = value;
	}

	@JsonProperty("name_of_data_collector_a0")
	public String getNameOfDataCollectorA0() {
		return nameOfDataCollectorA0;
	}

	@JsonProperty("name_of_data_collector_a0")
	public void setNameOfDataCollectorA0(String value) {
		this.nameOfDataCollectorA0 = value;
	}

	@JsonProperty("data_collector_email_b1")
	public String getDataCollectorEmailB1() {
		return dataCollectorEmailB1;
	}

	@JsonProperty("data_collector_email_b1")
	public void setDataCollectorEmailB1(String value) {
		this.dataCollectorEmailB1 = value;
	}

	@JsonProperty("data_collector_institution_b1")
	public String getDataCollectorInstitutionB1() {
		return dataCollectorInstitutionB1;
	}

	@JsonProperty("data_collector_institution_b1")
	public void setDataCollectorInstitutionB1(String value) {
		this.dataCollectorInstitutionB1 = value;
	}

	@JsonProperty("data_collector_telephone_number_b1")
	public String getDataCollectorTelephoneNumberB1() {
		return dataCollectorTelephoneNumberB1;
	}

	@JsonProperty("data_collector_telephone_number_b1")
	public void setDataCollectorTelephoneNumberB1(String value) {
		this.dataCollectorTelephoneNumberB1 = value;
	}

	@JsonProperty("form_completion_date_b1")
	public String getFormCompletionDateB1() {
		return formCompletionDateB1;
	}

	@JsonProperty("form_completion_date_b1")
	public void setFormCompletionDateB1(String value) {
		this.formCompletionDateB1 = value;
	}

	@JsonProperty("name_of_data_collector_b1")
	public String getNameOfDataCollectorB1() {
		return nameOfDataCollectorB1;
	}

	@JsonProperty("name_of_data_collector_b1")
	public void setNameOfDataCollectorB1(String value) {
		this.nameOfDataCollectorB1 = value;
	}
}
