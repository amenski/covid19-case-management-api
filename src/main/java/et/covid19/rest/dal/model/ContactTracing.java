package et.covid19.rest.dal.model;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import et.covid19.rest.dal.util.ContactTracingAttributConverter;


/**
 * The persistent class for the contact_tracing database table.
 * 
 */
@Entity
@Table(name="contact_tracing")
@NamedQuery(name="ContactTracing.findAll", query="SELECT c FROM ContactTracing c")
public class ContactTracing implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="parent_case_code")
	private String parentCaseCode;

	@JsonInclude(Include.NON_EMPTY)	
	@Column
	@Convert(converter = ContactTracingAttributConverter.class)
	private List<ContactTracing> children;

	@JsonIgnore
	@Column(name="modified_by")
	private String modifiedBy;

	@JsonIgnore
	@Column(name="modified_date")
	private OffsetDateTime modifiedDate;

	public ContactTracing() {
		//
	}

	public String getParentCaseCode() {
		return this.parentCaseCode;
	}

	public void setParentCaseCode(String parentCaseCode) {
		this.parentCaseCode = parentCaseCode;
	}

	public List<ContactTracing> getChildren() {
		return this.children;
	}

	public void setChildren(List<ContactTracing> children) {
		this.children = children;
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

	@Override
	public String toString() {
		return parentCaseCode;
	}
}