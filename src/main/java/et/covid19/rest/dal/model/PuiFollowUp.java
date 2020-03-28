package et.covid19.rest.dal.model;

import java.io.Serializable;
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
 * The persistent class for the pui_follow_up database table.
 * 
 */
@Entity
@Table(name="pui_follow_up")
@NamedQuery(name="PuiFollowUp.findAll", query="SELECT p FROM PuiFollowUp p")
public class PuiFollowUp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Integer id;

	@Column(name="created_date")
	private OffsetDateTime createdDate;

	private String description;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_date")
	private OffsetDateTime modifiedDate;

	@Column(name="option_selected")
	private String optionSelected;

	@Column(name="pui_case_code")
	private String puiCaseCode;

	@Column(name="questionier_id")
	private Integer questionierId;

	public PuiFollowUp() {
		//
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OffsetDateTime getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(OffsetDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getOptionSelected() {
		return this.optionSelected;
	}

	public void setOptionSelected(String optionSelected) {
		this.optionSelected = optionSelected;
	}

	public String getPuiCaseCode() {
		return this.puiCaseCode;
	}

	public void setPuiCaseCode(String puiCaseCode) {
		this.puiCaseCode = puiCaseCode;
	}

	public Integer getQuestionierId() {
		return this.questionierId;
	}

	public void setQuestionierId(Integer questionierId) {
		this.questionierId = questionierId;
	}

}