package et.covid19.rest.dal.model;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the rumor_reports database table.
 * 
 */
@Entity
@Table(name="rumor_reports")
@NamedQuery(name="RumorReport.findAll", query="SELECT r FROM RumorReport r")
public class RumorReport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rumor_id_seq_gen")
    @SequenceGenerator(name="rumor_id_seq_gen", sequenceName = "rumor_id_seq", allocationSize=1)
	private Integer id;

	private String address;

	private Boolean cough;

	private Boolean fever;

	private String gender;

	private Boolean headache;


	@Column(name="phone_number1")
	private String phoneNumber1;

	@Column(name="phone_number2")
	private String phoneNumber2;

	@Column(name="relation_with_suspect")
	private String relationWithSuspect;

	@Column(name="report_date")
	private OffsetDateTime reportDate;

	@Column(name="reporting_person_name")
	private String reportingPersonName;

	@Column(name="suspect_name")
	private String suspectName;

	@Column(name="symptoms_duration")
	private Integer symptomsDuration;

	public RumorReport() {
	    //
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getCough() {
		return this.cough;
	}

	public void setCough(Boolean cough) {
		this.cough = cough;
	}

	public Boolean getFever() {
		return this.fever;
	}

	public void setFever(Boolean fever) {
		this.fever = fever;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Boolean getHeadache() {
		return this.headache;
	}

	public void setHeadache(Boolean headache) {
		this.headache = headache;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhoneNumber1() {
		return this.phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return this.phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getRelationWithSuspect() {
		return this.relationWithSuspect;
	}

	public void setRelationWithSuspect(String relationWithSuspect) {
		this.relationWithSuspect = relationWithSuspect;
	}

	public OffsetDateTime getReportDate() {
		return this.reportDate;
	}

	public void setReportDate(OffsetDateTime reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportingPersonName() {
		return this.reportingPersonName;
	}

	public void setReportingPersonName(String reportingPersonName) {
		this.reportingPersonName = reportingPersonName;
	}

	public String getSuspectName() {
		return this.suspectName;
	}

	public void setSuspectName(String suspectName) {
		this.suspectName = suspectName;
	}

	public Integer getSymptomsDuration() {
		return this.symptomsDuration;
	}

	public void setSymptomsDuration(Integer symptomsDuration) {
		this.symptomsDuration = symptomsDuration;
	}

}