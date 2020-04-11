package et.covid19.rest.dal.model.security;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import et.covid19.rest.dal.model.EthUser;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name="role")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Boolean enabled;

	private String name;

	//bi-directional many-to-many association to EthUser
	@ManyToMany(mappedBy="roles")
	private List<EthUser> ethUsers;

	public Role() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EthUser> getEthUsers() {
		return this.ethUsers;
	}

	public void setEthUsers(List<EthUser> ethUsers) {
		this.ethUsers = ethUsers;
	}

}