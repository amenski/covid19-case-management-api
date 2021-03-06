package et.covid19.rest.dal.model;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pui_follow_up_gen")
	@SequenceGenerator(name="pui_follow_up_gen", sequenceName = "pui_follow_up_id_seq", allocationSize=1)
	private Long id;

	@Column(name="created_date")
	private OffsetDateTime createdDate;

	private String description;

	@Column(name="modified_by")
	private String modifiedBy;

	@Column(name="modified_date")
	private OffsetDateTime modifiedDate;

	@Column(name="option_selected")
	private String optionSelected;

	//uni-directional many-to-one association to Questionier
	@ManyToOne
	private Questionier questionier;
	
	//uni-directional many-to-one association to PuiInfo
	@ManyToOne
	@JoinColumn(name = "pui_case_code", referencedColumnName = "case_code")
	private PuiInfo puiInfo;
	
	public PuiFollowUp() {
		//
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
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

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
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

	public Questionier getQuestionier() {
		return questionier;
	}

	public void setQuestionier(Questionier questionier) {
		this.questionier = questionier;
	}

	public PuiInfo getPuiInfo() {
		return puiInfo;
	}

	public void setPuiInfo(PuiInfo puiInfo) {
		this.puiInfo = puiInfo;
	}

}