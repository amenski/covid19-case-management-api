package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class PatientSymptomsComplications {
	private AcuteRenalFailure acuteRenalFailure;
	private Ards ards;
	private CardiacFailure cardiacFailure;
	private ConsumptiveCoagulopathy consumptiveCoagulopathy;
	private DateOfDischarge dateOfDischarge;
	private String extracorporealMembraneOxygenationRequired;
	private PatientSymptomsComplicationsHospitalization hospitalization;
	private String hypotensionRequiringVasopressors;
	private Icu icu;
	private MechanicalVentilation mechanicalVentilation;
	private OtherComplications otherComplications;
	private String outcome;
	private OutcomeCurrentAsOfDate outcomeCurrentAsOfDate;
	private PneumoniaByChestXRay pneumoniaByChestXRay;

	@JsonProperty("acute_renal_failure")
	public AcuteRenalFailure getAcuteRenalFailure() {
		return acuteRenalFailure;
	}

	@JsonProperty("acute_renal_failure")
	public void setAcuteRenalFailure(AcuteRenalFailure value) {
		this.acuteRenalFailure = value;
	}

	@JsonProperty("ards")
	public Ards getArds() {
		return ards;
	}

	@JsonProperty("ards")
	public void setArds(Ards value) {
		this.ards = value;
	}

	@JsonProperty("cardiac_failure")
	public CardiacFailure getCardiacFailure() {
		return cardiacFailure;
	}

	@JsonProperty("cardiac_failure")
	public void setCardiacFailure(CardiacFailure value) {
		this.cardiacFailure = value;
	}

	@JsonProperty("consumptive_coagulopathy")
	public ConsumptiveCoagulopathy getConsumptiveCoagulopathy() {
		return consumptiveCoagulopathy;
	}

	@JsonProperty("consumptive_coagulopathy")
	public void setConsumptiveCoagulopathy(ConsumptiveCoagulopathy value) {
		this.consumptiveCoagulopathy = value;
	}

	@JsonProperty("date_of_discharge")
	public DateOfDischarge getDateOfDischarge() {
		return dateOfDischarge;
	}

	@JsonProperty("date_of_discharge")
	public void setDateOfDischarge(DateOfDischarge value) {
		this.dateOfDischarge = value;
	}

	@JsonProperty("extracorporeal_membrane_oxygenation_required")
	public String getExtracorporealMembraneOxygenationRequired() {
		return extracorporealMembraneOxygenationRequired;
	}

	@JsonProperty("extracorporeal_membrane_oxygenation_required")
	public void setExtracorporealMembraneOxygenationRequired(String value) {
		this.extracorporealMembraneOxygenationRequired = value;
	}

	@JsonProperty("hospitalization")
	public PatientSymptomsComplicationsHospitalization getHospitalization() {
		return hospitalization;
	}

	@JsonProperty("hospitalization")
	public void setHospitalization(PatientSymptomsComplicationsHospitalization value) {
		this.hospitalization = value;
	}

	@JsonProperty("hypotension_requiring_vasopressors")
	public String getHypotensionRequiringVasopressors() {
		return hypotensionRequiringVasopressors;
	}

	@JsonProperty("hypotension_requiring_vasopressors")
	public void setHypotensionRequiringVasopressors(String value) {
		this.hypotensionRequiringVasopressors = value;
	}

	@JsonProperty("icu")
	public Icu getIcu() {
		return icu;
	}

	@JsonProperty("icu")
	public void setIcu(Icu value) {
		this.icu = value;
	}

	@JsonProperty("mechanical_ventilation")
	public MechanicalVentilation getMechanicalVentilation() {
		return mechanicalVentilation;
	}

	@JsonProperty("mechanical_ventilation")
	public void setMechanicalVentilation(MechanicalVentilation value) {
		this.mechanicalVentilation = value;
	}

	@JsonProperty("other_complications")
	public OtherComplications getOtherComplications() {
		return otherComplications;
	}

	@JsonProperty("other_complications")
	public void setOtherComplications(OtherComplications value) {
		this.otherComplications = value;
	}

	@JsonProperty("outcome")
	public String getOutcome() {
		return outcome;
	}

	@JsonProperty("outcome")
	public void setOutcome(String value) {
		this.outcome = value;
	}

	@JsonProperty("outcome_current_as_of_date")
	public OutcomeCurrentAsOfDate getOutcomeCurrentAsOfDate() {
		return outcomeCurrentAsOfDate;
	}

	@JsonProperty("outcome_current_as_of_date")
	public void setOutcomeCurrentAsOfDate(OutcomeCurrentAsOfDate value) {
		this.outcomeCurrentAsOfDate = value;
	}

	@JsonProperty("pneumonia_by_chest_x-ray")
	public PneumoniaByChestXRay getPneumoniaByChestXRay() {
		return pneumoniaByChestXRay;
	}

	@JsonProperty("pneumonia_by_chest_x-ray")
	public void setPneumoniaByChestXRay(PneumoniaByChestXRay value) {
		this.pneumoniaByChestXRay = value;
	}
}
