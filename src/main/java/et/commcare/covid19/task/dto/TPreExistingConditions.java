package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class TPreExistingConditions {
	private String asthmaRequiringMedication;
	private String cancer;
	private String chronicHaematologicalDisorder;
	private String chronicKidneyDisease;
	private String chronicLiverDisease;
	private String chronicLungDisease;
	private String chronicNeurologicalImpairmentDisease;
	private String conditions;
	private String diabetes;
	private String heartDisease;
	private String hivOrOtherImmuneDeficiency;
	private String obesity;
	private String organOrBoneMarrowRecipient;
	private String otherPreExistingConditions;
	private String pregnancy;

	@JsonProperty("asthma_requiring_medication")
	public String getAsthmaRequiringMedication() {
		return asthmaRequiringMedication;
	}

	@JsonProperty("asthma_requiring_medication")
	public void setAsthmaRequiringMedication(String value) {
		this.asthmaRequiringMedication = value;
	}

	@JsonProperty("cancer")
	public String getCancer() {
		return cancer;
	}

	@JsonProperty("cancer")
	public void setCancer(String value) {
		this.cancer = value;
	}

	@JsonProperty("chronic_haematological_disorder")
	public String getChronicHaematologicalDisorder() {
		return chronicHaematologicalDisorder;
	}

	@JsonProperty("chronic_haematological_disorder")
	public void setChronicHaematologicalDisorder(String value) {
		this.chronicHaematologicalDisorder = value;
	}

	@JsonProperty("chronic_kidney_disease")
	public String getChronicKidneyDisease() {
		return chronicKidneyDisease;
	}

	@JsonProperty("chronic_kidney_disease")
	public void setChronicKidneyDisease(String value) {
		this.chronicKidneyDisease = value;
	}

	@JsonProperty("chronic_liver_disease")
	public String getChronicLiverDisease() {
		return chronicLiverDisease;
	}

	@JsonProperty("chronic_liver_disease")
	public void setChronicLiverDisease(String value) {
		this.chronicLiverDisease = value;
	}

	@JsonProperty("chronic_lung_disease")
	public String getChronicLungDisease() {
		return chronicLungDisease;
	}

	@JsonProperty("chronic_lung_disease")
	public void setChronicLungDisease(String value) {
		this.chronicLungDisease = value;
	}

	@JsonProperty("chronic_neurological_impairment_disease")
	public String getChronicNeurologicalImpairmentDisease() {
		return chronicNeurologicalImpairmentDisease;
	}

	@JsonProperty("chronic_neurological_impairment_disease")
	public void setChronicNeurologicalImpairmentDisease(String value) {
		this.chronicNeurologicalImpairmentDisease = value;
	}

	@JsonProperty("conditions")
	public String getConditions() {
		return conditions;
	}

	@JsonProperty("conditions")
	public void setConditions(String value) {
		this.conditions = value;
	}

	@JsonProperty("diabetes")
	public String getDiabetes() {
		return diabetes;
	}

	@JsonProperty("diabetes")
	public void setDiabetes(String value) {
		this.diabetes = value;
	}

	@JsonProperty("heart_disease")
	public String getHeartDisease() {
		return heartDisease;
	}

	@JsonProperty("heart_disease")
	public void setHeartDisease(String value) {
		this.heartDisease = value;
	}

	@JsonProperty("hiv_or_other_immune_deficiency")
	public String getHivOrOtherImmuneDeficiency() {
		return hivOrOtherImmuneDeficiency;
	}

	@JsonProperty("hiv_or_other_immune_deficiency")
	public void setHivOrOtherImmuneDeficiency(String value) {
		this.hivOrOtherImmuneDeficiency = value;
	}

	@JsonProperty("obesity")
	public String getObesity() {
		return obesity;
	}

	@JsonProperty("obesity")
	public void setObesity(String value) {
		this.obesity = value;
	}

	@JsonProperty("organ_or_bone_marrow_recipient")
	public String getOrganOrBoneMarrowRecipient() {
		return organOrBoneMarrowRecipient;
	}

	@JsonProperty("organ_or_bone_marrow_recipient")
	public void setOrganOrBoneMarrowRecipient(String value) {
		this.organOrBoneMarrowRecipient = value;
	}

	@JsonProperty("other_pre-existing_conditions")
	public String getOtherPreExistingConditions() {
		return otherPreExistingConditions;
	}

	@JsonProperty("other_pre-existing_conditions")
	public void setOtherPreExistingConditions(String value) {
		this.otherPreExistingConditions = value;
	}

	@JsonProperty("pregnancy")
	public String getPregnancy() {
		return pregnancy;
	}

	@JsonProperty("pregnancy")
	public void setPregnancy(String value) {
		this.pregnancy = value;
	}
}
