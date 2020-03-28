package et.covid19.rest.dal.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the pui_info database table.
 * 
 */
@Entity
@Table(name="pui_info")
@NamedQuery(name="PuiInfo.findAll", query="SELECT p FROM PuiInfo p")
public class PuiInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	// never use only @GeneratedValue(strategy = GenerationType.AUTO) since it generates hibernate_sequence table, and really bad choice
	// https://vladmihalcea.com/why-should-not-use-the-auto-jpa-generationtype-with-mysql-and-hibernate/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Integer id;

	@Column(name="case_code")
	private String caseCode;

	@Column(name="confirmed_result")
	private Integer confirmedResult;

	@Column(name="contact_parent_case_code")
	private String contactParentCaseCode;

	@Column(name="country_of_origin")
	private String countryOfOrigin;

	@Column(name="country_of_residence")
	private String countryOfResidence;

	private LocalDate dob;

	@Column(name="first_name")
	private String firstName;

	private String gender;

	private String houseNo;

	@Column(name="identified_by")
	private Integer identifiedBy;

	@Column(name="incident_contact_phone_1")
	private String incidentContactPhone1;

	@Column(name="incident_contact_phone_2")
	private String incidentContactPhone2;

	private String kebele;

	@Column(name="last_name")
	private String lastName;

	private String latitude;

	private String longitude;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_date")
	private OffsetDateTime modifiedDate;

	private String nationality;

	private String occupation;

	@Column(name="passport_number")
	private String passportNumber;

	private String phone;

	private String phoneNo;

	@Column(name="presumptive_result")
	private Integer presumptiveResult;

	private String region;

	@Column(name="reporting_date")
	private OffsetDateTime reportingDate;

	private String subcityOrZone;

	@Column(name="travel_history_id")
	private Integer travelHistoryId;

	private String woreda;

	public PuiInfo() {
		//
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCaseCode() {
		return this.caseCode;
	}

	public void setCaseCode(String caseCode) {
		this.caseCode = caseCode;
	}

	public Integer getConfirmedResult() {
		return this.confirmedResult;
	}

	public void setConfirmedResult(Integer confirmedResult) {
		this.confirmedResult = confirmedResult;
	}

	public String getContactParentCaseCode() {
		return this.contactParentCaseCode;
	}

	public void setContactParentCaseCode(String contactParentCaseCode) {
		this.contactParentCaseCode = contactParentCaseCode;
	}

	public String getCountryOfOrigin() {
		return this.countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public String getCountryOfResidence() {
		return this.countryOfResidence;
	}

	public void setCountryOfResidence(String countryOfResidence) {
		this.countryOfResidence = countryOfResidence;
	}

	public LocalDate getDob() {
		return this.dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHouseNo() {
		return this.houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public Integer getIdentifiedBy() {
		return this.identifiedBy;
	}

	public void setIdentifiedBy(Integer identifiedBy) {
		this.identifiedBy = identifiedBy;
	}

	public String getIncidentContactPhone1() {
		return this.incidentContactPhone1;
	}

	public void setIncidentContactPhone1(String incidentContactPhone1) {
		this.incidentContactPhone1 = incidentContactPhone1;
	}

	public String getIncidentContactPhone2() {
		return this.incidentContactPhone2;
	}

	public void setIncidentContactPhone2(String incidentContactPhone2) {
		this.incidentContactPhone2 = incidentContactPhone2;
	}

	public String getKebele() {
		return this.kebele;
	}

	public void setKebele(String kebele) {
		this.kebele = kebele;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Integer getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public OffsetDateTime getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(OffsetDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPassportNumber() {
		return this.passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Integer getPresumptiveResult() {
		return this.presumptiveResult;
	}

	public void setPresumptiveResult(Integer presumptiveResult) {
		this.presumptiveResult = presumptiveResult;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public OffsetDateTime getReportingDate() {
		return this.reportingDate;
	}

	public void setReportingDate(OffsetDateTime reportingDate) {
		this.reportingDate = reportingDate;
	}

	public String getSubcityOrZone() {
		return this.subcityOrZone;
	}

	public void setSubcityOrZone(String subcityOrZone) {
		this.subcityOrZone = subcityOrZone;
	}

	public int getTravelHistoryId() {
		return this.travelHistoryId;
	}

	public void setTravelHistoryId(int travelHistoryId) {
		this.travelHistoryId = travelHistoryId;
	}

	public String getWoreda() {
		return this.woreda;
	}

	public void setWoreda(String woreda) {
		this.woreda = woreda;
	}

}