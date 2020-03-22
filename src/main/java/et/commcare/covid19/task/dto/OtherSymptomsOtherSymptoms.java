package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class OtherSymptomsOtherSymptoms {
	private String alteredConsciousness;
	private HasContacts chills;
	private String conjunctivitis;
	private String diarrhoea;
	private String fatigue;
	private String headache;
	private HasContacts jointAche;
	private String lossOfAppetite;
	private String muscleAches;
	private HasContacts nausea;
	private String noseBleed;
	private String otherNeurologicalSigns;
	private String otherSymptoms;
	private String rash;
	private String seizures;
	private String symptom;
	private String vomiting;

	@JsonProperty("altered_consciousness")
	public String getAlteredConsciousness() {
		return alteredConsciousness;
	}

	@JsonProperty("altered_consciousness")
	public void setAlteredConsciousness(String value) {
		this.alteredConsciousness = value;
	}

	@JsonProperty("chills")
	public HasContacts getChills() {
		return chills;
	}

	@JsonProperty("chills")
	public void setChills(HasContacts value) {
		this.chills = value;
	}

	@JsonProperty("conjunctivitis")
	public String getConjunctivitis() {
		return conjunctivitis;
	}

	@JsonProperty("conjunctivitis")
	public void setConjunctivitis(String value) {
		this.conjunctivitis = value;
	}

	@JsonProperty("diarrhoea")
	public String getDiarrhoea() {
		return diarrhoea;
	}

	@JsonProperty("diarrhoea")
	public void setDiarrhoea(String value) {
		this.diarrhoea = value;
	}

	@JsonProperty("fatigue")
	public String getFatigue() {
		return fatigue;
	}

	@JsonProperty("fatigue")
	public void setFatigue(String value) {
		this.fatigue = value;
	}

	@JsonProperty("headache")
	public String getHeadache() {
		return headache;
	}

	@JsonProperty("headache")
	public void setHeadache(String value) {
		this.headache = value;
	}

	@JsonProperty("joint_ache")
	public HasContacts getJointAche() {
		return jointAche;
	}

	@JsonProperty("joint_ache")
	public void setJointAche(HasContacts value) {
		this.jointAche = value;
	}

	@JsonProperty("loss_of_appetite")
	public String getLossOfAppetite() {
		return lossOfAppetite;
	}

	@JsonProperty("loss_of_appetite")
	public void setLossOfAppetite(String value) {
		this.lossOfAppetite = value;
	}

	@JsonProperty("muscle_aches")
	public String getMuscleAches() {
		return muscleAches;
	}

	@JsonProperty("muscle_aches")
	public void setMuscleAches(String value) {
		this.muscleAches = value;
	}

	@JsonProperty("nausea")
	public HasContacts getNausea() {
		return nausea;
	}

	@JsonProperty("nausea")
	public void setNausea(HasContacts value) {
		this.nausea = value;
	}

	@JsonProperty("nose_bleed")
	public String getNoseBleed() {
		return noseBleed;
	}

	@JsonProperty("nose_bleed")
	public void setNoseBleed(String value) {
		this.noseBleed = value;
	}

	@JsonProperty("other_neurological_signs")
	public String getOtherNeurologicalSigns() {
		return otherNeurologicalSigns;
	}

	@JsonProperty("other_neurological_signs")
	public void setOtherNeurologicalSigns(String value) {
		this.otherNeurologicalSigns = value;
	}

	@JsonProperty("other_symptoms")
	public String getOtherSymptoms() {
		return otherSymptoms;
	}

	@JsonProperty("other_symptoms")
	public void setOtherSymptoms(String value) {
		this.otherSymptoms = value;
	}

	@JsonProperty("rash")
	public String getRash() {
		return rash;
	}

	@JsonProperty("rash")
	public void setRash(String value) {
		this.rash = value;
	}

	@JsonProperty("seizures")
	public String getSeizures() {
		return seizures;
	}

	@JsonProperty("seizures")
	public void setSeizures(String value) {
		this.seizures = value;
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
