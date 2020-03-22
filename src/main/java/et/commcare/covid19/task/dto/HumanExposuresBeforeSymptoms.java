package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class HumanExposuresBeforeSymptoms {
	private HumanExposuresBeforeSymptomsContactWithConfirmedCase contactWithConfirmedCase;
	private DomesticTravel domesticTravel;
	private String exposedToPersonWithSimilarIllness;
	private FestivalMassGathering festivalMassGathering;
	private InpatientFacility inpatientFacility;
	private InternationalTravel internationalTravel;
	private LocationOfExposure locationOfExposure;
	private OutpatientFacility outpatientFacility;
	private HumanExposuresBeforeSymptomsPatientOccupation patientOccupation;
	private TraditionalHealer traditionalHealer;

	@JsonProperty("contact_with_confirmed_case")
	public HumanExposuresBeforeSymptomsContactWithConfirmedCase getContactWithConfirmedCase() {
		return contactWithConfirmedCase;
	}

	@JsonProperty("contact_with_confirmed_case")
	public void setContactWithConfirmedCase(HumanExposuresBeforeSymptomsContactWithConfirmedCase value) {
		this.contactWithConfirmedCase = value;
	}

	@JsonProperty("domestic_travel")
	public DomesticTravel getDomesticTravel() {
		return domesticTravel;
	}

	@JsonProperty("domestic_travel")
	public void setDomesticTravel(DomesticTravel value) {
		this.domesticTravel = value;
	}

	@JsonProperty("exposed_to_person_with_similar_illness")
	public String getExposedToPersonWithSimilarIllness() {
		return exposedToPersonWithSimilarIllness;
	}

	@JsonProperty("exposed_to_person_with_similar_illness")
	public void setExposedToPersonWithSimilarIllness(String value) {
		this.exposedToPersonWithSimilarIllness = value;
	}

	@JsonProperty("festival_mass_gathering")
	public FestivalMassGathering getFestivalMassGathering() {
		return festivalMassGathering;
	}

	@JsonProperty("festival_mass_gathering")
	public void setFestivalMassGathering(FestivalMassGathering value) {
		this.festivalMassGathering = value;
	}

	@JsonProperty("inpatient_facility")
	public InpatientFacility getInpatientFacility() {
		return inpatientFacility;
	}

	@JsonProperty("inpatient_facility")
	public void setInpatientFacility(InpatientFacility value) {
		this.inpatientFacility = value;
	}

	@JsonProperty("international_travel")
	public InternationalTravel getInternationalTravel() {
		return internationalTravel;
	}

	@JsonProperty("international_travel")
	public void setInternationalTravel(InternationalTravel value) {
		this.internationalTravel = value;
	}

	@JsonProperty("location_of_exposure")
	public LocationOfExposure getLocationOfExposure() {
		return locationOfExposure;
	}

	@JsonProperty("location_of_exposure")
	public void setLocationOfExposure(LocationOfExposure value) {
		this.locationOfExposure = value;
	}

	@JsonProperty("outpatient_facility")
	public OutpatientFacility getOutpatientFacility() {
		return outpatientFacility;
	}

	@JsonProperty("outpatient_facility")
	public void setOutpatientFacility(OutpatientFacility value) {
		this.outpatientFacility = value;
	}

	@JsonProperty("patient_occupation")
	public HumanExposuresBeforeSymptomsPatientOccupation getPatientOccupation() {
		return patientOccupation;
	}

	@JsonProperty("patient_occupation")
	public void setPatientOccupation(HumanExposuresBeforeSymptomsPatientOccupation value) {
		this.patientOccupation = value;
	}

	@JsonProperty("traditional_healer")
	public TraditionalHealer getTraditionalHealer() {
		return traditionalHealer;
	}

	@JsonProperty("traditional_healer")
	public void setTraditionalHealer(TraditionalHealer value) {
		this.traditionalHealer = value;
	}
}
