package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Symptoms {
	private String cough;
	private String diarrhoea;
	private String feverOrHistoryOfFever;
	private String nausea;
	private String runnyNose;
	private String shortnessOfBreath;
	private String soreThroat;
	private String symptom;
	private String vomiting;

	@JsonProperty("cough")
	public String getCough() {
		return cough;
	}

	@JsonProperty("cough")
	public void setCough(String value) {
		this.cough = value;
	}

	@JsonProperty("diarrhoea")
	public String getDiarrhoea() {
		return diarrhoea;
	}

	@JsonProperty("diarrhoea")
	public void setDiarrhoea(String value) {
		this.diarrhoea = value;
	}

	@JsonProperty("fever_or_history_of_fever")
	public String getFeverOrHistoryOfFever() {
		return feverOrHistoryOfFever;
	}

	@JsonProperty("fever_or_history_of_fever")
	public void setFeverOrHistoryOfFever(String value) {
		this.feverOrHistoryOfFever = value;
	}

	@JsonProperty("nausea")
	public String getNausea() {
		return nausea;
	}

	@JsonProperty("nausea")
	public void setNausea(String value) {
		this.nausea = value;
	}

	@JsonProperty("runny_nose")
	public String getRunnyNose() {
		return runnyNose;
	}

	@JsonProperty("runny_nose")
	public void setRunnyNose(String value) {
		this.runnyNose = value;
	}

	@JsonProperty("shortness_of_breath")
	public String getShortnessOfBreath() {
		return shortnessOfBreath;
	}

	@JsonProperty("shortness_of_breath")
	public void setShortnessOfBreath(String value) {
		this.shortnessOfBreath = value;
	}

	@JsonProperty("sore_throat")
	public String getSoreThroat() {
		return soreThroat;
	}

	@JsonProperty("sore_throat")
	public void setSoreThroat(String value) {
		this.soreThroat = value;
	}

	@JsonProperty("symptom")
	public String getSymptom() {
		return symptom;
	}

	@JsonProperty("symptom")
	public void setSymptom(String value) {
		this.symptom = value;
	}

	@JsonProperty("vomiting")
	public String getVomiting() {
		return vomiting;
	}

	@JsonProperty("vomiting")
	public void setVomiting(String value) {
		this.vomiting = value;
	}
}
