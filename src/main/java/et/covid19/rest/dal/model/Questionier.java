package et.covid19.rest.dal.model;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import et.covid19.rest.dal.util.StringColumnToListConverter;


/**
 * The persistent class for the questionier database table.
 * 
 */
@Entity
@NamedQuery(name="Questionier.findAll", query="SELECT q FROM Questionier q")
public class Questionier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questionier_id_gen")
	@SequenceGenerator(name="questionier_id_gen", sequenceName = "questionier_id_seq", allocationSize=1)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "category", referencedColumnName = "enum_code")
	private ConstantEnum category;

	@Column(name="created_date")
	private OffsetDateTime createdDate;

	private String description;

	@Column(name="modified_by")
	private String modifiedBy;

	@Column(name="modified_date")
	private OffsetDateTime modifiedDate;

	@Convert(converter = StringColumnToListConverter.class)
	private List<String> options;

	@Column(name="parent_id")
	private int parentId;

	private String question;

	@Column(name="inactive")
	private boolean inActive;
	
	public Questionier() {
		//
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ConstantEnum getCategory() {
        return category;
    }

    public void setCategory(ConstantEnum category) {
        this.category = category;
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

	public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public int getParentId() {
		return this.parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

    public boolean isInActive() {
        return inActive;
    }

    public void setInActive(boolean inActive) {
        this.inActive = inActive;
    }

}