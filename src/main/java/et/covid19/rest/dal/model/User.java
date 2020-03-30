package et.covid19.rest.dal.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import et.covid19.rest.dal.model.security.Role;

import java.time.OffsetDateTime;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Integer id;

	@Column(name="account_non_expired")
	private boolean accountNonExpired;

	@Column(name="account_non_locked")
	private boolean accountNonLocked;

	private boolean enabled;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_access")
	private OffsetDateTime lastAccess;

	@Column(name="last_name")
	private String lastName;

	private String password;

	private String username;

	//uni-directional many-to-many association to Role1
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name="user_roles", 
		joinColumns={@JoinColumn(name="user_id")}, 
		inverseJoinColumns={@JoinColumn(name="role_id")}
	)
	private List<Role> roles;

	public User() {
		//
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean getAccountNonExpired() {
		return this.accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean getAccountNonLocked() {
		return this.accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public OffsetDateTime getLastAccess() {
		return this.lastAccess;
	}

	public void setLastAccess(OffsetDateTime lastAccess) {
		this.lastAccess = lastAccess;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}