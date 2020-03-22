package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class PatientIdentifierInformation {
	private String suspected;
	private BasicDemo basicDemo;
	private CovidID covidID;
	private String fullAddress;
	private PatientCaseStatus patientCaseStatus;
	private String patientNameLastFirst;
	private String underlyingCondition;
	private PatientIdentifierInformationDateOfBirth dateOfBirth;
	private Name name;
	private NormalizedAgeDetails normalizedAgeDetails;
	private OtherDetails otherDetails;
	private PatientAge patientAge;
	private String patientSex;
	private String patientTelephoneMobileNumber;
	private Confirmed confirmed;
	private Patient3 patient3;
	private PatientIdentifierInformationPatientOccupation patientOccupation;
	private Suspect suspect;

	@JsonProperty("Suspected")
	public String getSuspected() {
		return suspected;
	}

	@JsonProperty("Suspected")
	public void setSuspected(String value) {
		this.suspected = value;
	}

	@JsonProperty("basic_demo")
	public BasicDemo getBasicDemo() {
		return basicDemo;
	}

	@JsonProperty("basic_demo")
	public void setBasicDemo(BasicDemo value) {
		this.basicDemo = value;
	}

	@JsonProperty("covid_id")
	public CovidID getCovidID() {
		return covidID;
	}

	@JsonProperty("covid_id")
	public void setCovidID(CovidID value) {
		this.covidID = value;
	}

	@JsonProperty("full_address")
	public String getFullAddress() {
		return fullAddress;
	}

	@JsonProperty("full_address")
	public void setFullAddress(String value) {
		this.fullAddress = value;
	}

	@JsonProperty("patient_case_status")
	public PatientCaseStatus getPatientCaseStatus() {
		return patientCaseStatus;
	}

	@JsonProperty("patient_case_status")
	public void setPatientCaseStatus(PatientCaseStatus value) {
		this.patientCaseStatus = value;
	}

	@JsonProperty("patient_name_last_first")
	public String getPatientNameLastFirst() {
		return patientNameLastFirst;
	}

	@JsonProperty("patient_name_last_first")
	public void setPatientNameLastFirst(String value) {
		this.patientNameLastFirst = value;
	}

	@JsonProperty("underlying_condition")
	public String getUnderlyingCondition() {
		return underlyingCondition;
	}

	@JsonProperty("underlying_condition")
	public void setUnderlyingCondition(String value) {
		this.underlyingCondition = value;
	}

	@JsonProperty("date_of_birth")
	public PatientIdentifierInformationDateOfBirth getDateOfBirth() {
		return dateOfBirth;
	}

	@JsonProperty("date_of_birth")
	public void setDateOfBirth(PatientIdentifierInformationDateOfBirth value) {
		this.dateOfBirth = value;
	}

	@JsonProperty("name")
	public Name getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(Name value) {
		this.name = value;
	}

	@JsonProperty("normalized_age_details")
	public NormalizedAgeDetails getNormalizedAgeDetails() {
		return normalizedAgeDetails;
	}

	@JsonProperty("normalized_age_details")
	public void setNormalizedAgeDetails(NormalizedAgeDetails value) {
		this.normalizedAgeDetails = value;
	}

	@JsonProperty("other_details")
	public OtherDetails getOtherDetails() {
		return otherDetails;
	}

	@JsonProperty("other_details")
	public void setOtherDetails(OtherDetails value) {
		this.otherDetails = value;
	}

	@JsonProperty("patient_age")
	public PatientAge getPatientAge() {
		return patientAge;
	}

	@JsonProperty("patient_age")
	public void setPatientAge(PatientAge value) {
		this.patientAge = value;
	}

	@JsonProperty("patient_sex")
	public String getPatientSex() {
		return patientSex;
	}

	@JsonProperty("patient_sex")
	public void setPatientSex(String value) {
		this.patientSex = value;
	}

	@JsonProperty("patient_telephone_mobile_number")
	public String getPatientTelephoneMobileNumber() {
		return patientTelephoneMobileNumber;
	}

	@JsonProperty("patient_telephone_mobile_number")
	public void setPatientTelephoneMobileNumber(String value) {
		this.patientTelephoneMobileNumber = value;
	}

	@JsonProperty("confirmed")
	public Confirmed getConfirmed() {
		return confirmed;
	}

	@JsonProperty("confirmed")
	public void setConfirmed(Confirmed value) {
		this.confirmed = value;
	}

	@JsonProperty("patient_3")
	public Patient3 getPatient3() {
		return patient3;
	}

	@JsonProperty("patient_3")
	public void setPatient3(Patient3 value) {
		this.patient3 = value;
	}

	@JsonProperty("patient_occupation")
	public PatientIdentifierInformationPatientOccupation getPatientOccupation() {
		return patientOccupation;
	}

	@JsonProperty("patient_occupation")
	public void setPatientOccupation(PatientIdentifierInformationPatientOccupation value) {
		this.patientOccupation = value;
	}

	@JsonProperty("suspect")
	public Suspect getSuspect() {
		return suspect;
	}

	@JsonProperty("suspect")
	public void setSuspect(Suspect value) {
		this.suspect = value;
	}
}
