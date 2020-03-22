package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Form {
	private Type type;
	private String name;
	private String uiVersion;
	private String version;
	private String xmlns;
	private FormCase formCase;
	private ConsentList consentList;
	private MetadataClass meta;
	private PatientIdentifierInformation patientIdentifierInformation;
	private ClinicalCourseComplications clinicalCourseComplications;
	private CurrentStatusClass formCurrentStatus;
	private FormDataCollectorInformation dataCollectorInformation;
	private HumanExposuresBeforeSymptoms humanExposuresBeforeSymptoms;
	private HumanExposuresToAnimals humanExposuresToAnimals;
	private InitialSampleCollection initialSampleCollection;
	private PatientSymptoms patientSymptoms;
	private HasContacts patientWasEverHospitalized;
	private String respondentProviding;
	private FormStatusOfFormCompletion statusOfFormCompletion;
	private String uniqueCaseID;
	private CurrentStatus currentStatus;
	private ContactDetails contactDetails;
	private ContactPreExistingConditions contactPreExistingConditions;
	private ExposureInformationContactNotHw exposureInformationContactNotHw;
	private GeneralExposureInformation generalExposureInformation;
	private HasContacts hasContacts;
	private Labels labels;
	private FormOtherSymptoms otherSymptoms;
	private OutcomeStatus outcomeStatus;
	private RespiratorySymptoms respiratorySymptoms;
	private Subcase0 subcase0;
	private SymptomsInContact symptomsInContact;
	private CommentLabel commentLabel;
	private FurtherCaseClassification furtherCaseClassification;
	private HealthCareCentreTreatingPhysicianDetails healthCareCentreTreatingPhysicianDetails;
	private HealthCareInteractions healthCareInteractions;
	private PatientCaseStatus patientCaseStatus;
	private PatientPreExistingConditions patientPreExistingConditions;
	private PatientSymptomsComplications patientSymptomsComplications;

	@JsonProperty("#type")
	public Type getType() {
		return type;
	}

	@JsonProperty("#type")
	public void setType(Type value) {
		this.type = value;
	}

	@JsonProperty("@name")
	public String getName() {
		return name;
	}

	@JsonProperty("@name")
	public void setName(String value) {
		this.name = value;
	}

	@JsonProperty("@uiVersion")
	public String getUIVersion() {
		return uiVersion;
	}

	@JsonProperty("@uiVersion")
	public void setUIVersion(String value) {
		this.uiVersion = value;
	}

	@JsonProperty("@version")
	public String getVersion() {
		return version;
	}

	@JsonProperty("@version")
	public void setVersion(String value) {
		this.version = value;
	}

	@JsonProperty("@xmlns")
	public String getXmlns() {
		return xmlns;
	}

	@JsonProperty("@xmlns")
	public void setXmlns(String value) {
		this.xmlns = value;
	}

	@JsonProperty("case")
	public FormCase getFormCase() {
		return formCase;
	}

	@JsonProperty("case")
	public void setFormCase(FormCase value) {
		this.formCase = value;
	}

	@JsonProperty("consent_list")
	public ConsentList getConsentList() {
		return consentList;
	}

	@JsonProperty("consent_list")
	public void setConsentList(ConsentList value) {
		this.consentList = value;
	}

	@JsonProperty("meta")
	public MetadataClass getMeta() {
		return meta;
	}

	@JsonProperty("meta")
	public void setMeta(MetadataClass value) {
		this.meta = value;
	}

	@JsonProperty("patient_identifier_information")
	public PatientIdentifierInformation getPatientIdentifierInformation() {
		return patientIdentifierInformation;
	}

	@JsonProperty("patient_identifier_information")
	public void setPatientIdentifierInformation(PatientIdentifierInformation value) {
		this.patientIdentifierInformation = value;
	}

	@JsonProperty("clinical_course_complications")
	public ClinicalCourseComplications getClinicalCourseComplications() {
		return clinicalCourseComplications;
	}

	@JsonProperty("clinical_course_complications")
	public void setClinicalCourseComplications(ClinicalCourseComplications value) {
		this.clinicalCourseComplications = value;
	}

	@JsonProperty("current_status")
	public CurrentStatusClass getFormCurrentStatus() {
		return formCurrentStatus;
	}

	@JsonProperty("current_status")
	public void setFormCurrentStatus(CurrentStatusClass value) {
		this.formCurrentStatus = value;
	}

	@JsonProperty("data_collector_information")
	public FormDataCollectorInformation getDataCollectorInformation() {
		return dataCollectorInformation;
	}

	@JsonProperty("data_collector_information")
	public void setDataCollectorInformation(FormDataCollectorInformation value) {
		this.dataCollectorInformation = value;
	}

	@JsonProperty("human_exposures_before_symptoms")
	public HumanExposuresBeforeSymptoms getHumanExposuresBeforeSymptoms() {
		return humanExposuresBeforeSymptoms;
	}

	@JsonProperty("human_exposures_before_symptoms")
	public void setHumanExposuresBeforeSymptoms(HumanExposuresBeforeSymptoms value) {
		this.humanExposuresBeforeSymptoms = value;
	}

	@JsonProperty("human_exposures_to_animals")
	public HumanExposuresToAnimals getHumanExposuresToAnimals() {
		return humanExposuresToAnimals;
	}

	@JsonProperty("human_exposures_to_animals")
	public void setHumanExposuresToAnimals(HumanExposuresToAnimals value) {
		this.humanExposuresToAnimals = value;
	}

	@JsonProperty("initial_sample_collection")
	public InitialSampleCollection getInitialSampleCollection() {
		return initialSampleCollection;
	}

	@JsonProperty("initial_sample_collection")
	public void setInitialSampleCollection(InitialSampleCollection value) {
		this.initialSampleCollection = value;
	}

	@JsonProperty("patient_symptoms")
	public PatientSymptoms getPatientSymptoms() {
		return patientSymptoms;
	}

	@JsonProperty("patient_symptoms")
	public void setPatientSymptoms(PatientSymptoms value) {
		this.patientSymptoms = value;
	}

	@JsonProperty("patient_was_ever_hospitalized")
	public HasContacts getPatientWasEverHospitalized() {
		return patientWasEverHospitalized;
	}

	@JsonProperty("patient_was_ever_hospitalized")
	public void setPatientWasEverHospitalized(HasContacts value) {
		this.patientWasEverHospitalized = value;
	}

	@JsonProperty("respondent_providing")
	public String getRespondentProviding() {
		return respondentProviding;
	}

	@JsonProperty("respondent_providing")
	public void setRespondentProviding(String value) {
		this.respondentProviding = value;
	}

	@JsonProperty("status_of_form_completion")
	public FormStatusOfFormCompletion getStatusOfFormCompletion() {
		return statusOfFormCompletion;
	}

	@JsonProperty("status_of_form_completion")
	public void setStatusOfFormCompletion(FormStatusOfFormCompletion value) {
		this.statusOfFormCompletion = value;
	}

	@JsonProperty("unique_case_id")
	public String getUniqueCaseID() {
		return uniqueCaseID;
	}

	@JsonProperty("unique_case_id")
	public void setUniqueCaseID(String value) {
		this.uniqueCaseID = value;
	}

	@JsonProperty("Current_Status")
	public CurrentStatus getCurrentStatus() {
		return currentStatus;
	}

	@JsonProperty("Current_Status")
	public void setCurrentStatus(CurrentStatus value) {
		this.currentStatus = value;
	}

	@JsonProperty("contact_details")
	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	@JsonProperty("contact_details")
	public void setContactDetails(ContactDetails value) {
		this.contactDetails = value;
	}

	@JsonProperty("contact_pre_existing_conditions")
	public ContactPreExistingConditions getContactPreExistingConditions() {
		return contactPreExistingConditions;
	}

	@JsonProperty("contact_pre_existing_conditions")
	public void setContactPreExistingConditions(ContactPreExistingConditions value) {
		this.contactPreExistingConditions = value;
	}

	@JsonProperty("exposure_information_contact_not_hw")
	public ExposureInformationContactNotHw getExposureInformationContactNotHw() {
		return exposureInformationContactNotHw;
	}

	@JsonProperty("exposure_information_contact_not_hw")
	public void setExposureInformationContactNotHw(ExposureInformationContactNotHw value) {
		this.exposureInformationContactNotHw = value;
	}

	@JsonProperty("general_exposure_information")
	public GeneralExposureInformation getGeneralExposureInformation() {
		return generalExposureInformation;
	}

	@JsonProperty("general_exposure_information")
	public void setGeneralExposureInformation(GeneralExposureInformation value) {
		this.generalExposureInformation = value;
	}

	@JsonProperty("has_contacts")
	public HasContacts getHasContacts() {
		return hasContacts;
	}

	@JsonProperty("has_contacts")
	public void setHasContacts(HasContacts value) {
		this.hasContacts = value;
	}

	@JsonProperty("labels")
	public Labels getLabels() {
		return labels;
	}

	@JsonProperty("labels")
	public void setLabels(Labels value) {
		this.labels = value;
	}

	@JsonProperty("other_symptoms")
	public FormOtherSymptoms getOtherSymptoms() {
		return otherSymptoms;
	}

	@JsonProperty("other_symptoms")
	public void setOtherSymptoms(FormOtherSymptoms value) {
		this.otherSymptoms = value;
	}

	@JsonProperty("outcome_status")
	public OutcomeStatus getOutcomeStatus() {
		return outcomeStatus;
	}

	@JsonProperty("outcome_status")
	public void setOutcomeStatus(OutcomeStatus value) {
		this.outcomeStatus = value;
	}

	@JsonProperty("respiratory_symptoms")
	public RespiratorySymptoms getRespiratorySymptoms() {
		return respiratorySymptoms;
	}

	@JsonProperty("respiratory_symptoms")
	public void setRespiratorySymptoms(RespiratorySymptoms value) {
		this.respiratorySymptoms = value;
	}

	@JsonProperty("subcase_0")
	public Subcase0 getSubcase0() {
		return subcase0;
	}

	@JsonProperty("subcase_0")
	public void setSubcase0(Subcase0 value) {
		this.subcase0 = value;
	}

	@JsonProperty("symptoms_in_contact")
	public SymptomsInContact getSymptomsInContact() {
		return symptomsInContact;
	}

	@JsonProperty("symptoms_in_contact")
	public void setSymptomsInContact(SymptomsInContact value) {
		this.symptomsInContact = value;
	}

	@JsonProperty("comment_label")
	public CommentLabel getCommentLabel() {
		return commentLabel;
	}

	@JsonProperty("comment_label")
	public void setCommentLabel(CommentLabel value) {
		this.commentLabel = value;
	}

	@JsonProperty("further_case_classification")
	public FurtherCaseClassification getFurtherCaseClassification() {
		return furtherCaseClassification;
	}

	@JsonProperty("further_case_classification")
	public void setFurtherCaseClassification(FurtherCaseClassification value) {
		this.furtherCaseClassification = value;
	}

	@JsonProperty("health-care_centre_treating_physician_details")
	public HealthCareCentreTreatingPhysicianDetails getHealthCareCentreTreatingPhysicianDetails() {
		return healthCareCentreTreatingPhysicianDetails;
	}

	@JsonProperty("health-care_centre_treating_physician_details")
	public void setHealthCareCentreTreatingPhysicianDetails(HealthCareCentreTreatingPhysicianDetails value) {
		this.healthCareCentreTreatingPhysicianDetails = value;
	}

	@JsonProperty("health-care_interactions")
	public HealthCareInteractions getHealthCareInteractions() {
		return healthCareInteractions;
	}

	@JsonProperty("health-care_interactions")
	public void setHealthCareInteractions(HealthCareInteractions value) {
		this.healthCareInteractions = value;
	}

	@JsonProperty("patient_case_status")
	public PatientCaseStatus getPatientCaseStatus() {
		return patientCaseStatus;
	}

	@JsonProperty("patient_case_status")
	public void setPatientCaseStatus(PatientCaseStatus value) {
		this.patientCaseStatus = value;
	}

	@JsonProperty("patient_pre-existing_conditions")
	public PatientPreExistingConditions getPatientPreExistingConditions() {
		return patientPreExistingConditions;
	}

	@JsonProperty("patient_pre-existing_conditions")
	public void setPatientPreExistingConditions(PatientPreExistingConditions value) {
		this.patientPreExistingConditions = value;
	}

	@JsonProperty("patient_symptoms_complications")
	public PatientSymptomsComplications getPatientSymptomsComplications() {
		return patientSymptomsComplications;
	}

	@JsonProperty("patient_symptoms_complications")
	public void setPatientSymptomsComplications(PatientSymptomsComplications value) {
		this.patientSymptomsComplications = value;
	}
}
