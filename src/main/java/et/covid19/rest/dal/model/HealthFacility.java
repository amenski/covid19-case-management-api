package et.covid19.rest.dal.model;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the health_facility database table.
 * 
 */
@Entity
@Table(name="health_facility")
@NamedQuery(name="HealthFacility.findAll", query="SELECT h FROM HealthFacility h")
public class HealthFacility implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private int id;

	private String addrfull;

	private String amenity;

	private String name;

	@Column(name="OSM_ID")
	private Double osmId;

	@Column(name="X_CORD")
	private Double xCord;

	@Column(name="Y_CORD")
	private Double yCord;

	@Column(name = "modified_by")
	private String modifiedBy;
	
	@Column(name = "modified_date")
	private OffsetDateTime modifiedDate;
	
	public HealthFacility() {
		//
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddrfull() {
		return this.addrfull;
	}

	public void setAddrfull(String addrfull) {
		this.addrfull = addrfull;
	}

	public String getAmenity() {
		return this.amenity;
	}

	public void setAmenity(String amenity) {
		this.amenity = amenity;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getOsmId() {
		return this.osmId;
	}

	public void setOsmId(Double osmId) {
		this.osmId = osmId;
	}

	public Double getXCord() {
		return this.xCord;
	}

	public void setXCord(Double xCord) {
		this.xCord = xCord;
	}

	public Double getYCord() {
		return this.yCord;
	}

	public void setYCord(Double yCord) {
		this.yCord = yCord;
	}

	public Double getxCord() {
		return xCord;
	}

	public void setxCord(Double xCord) {
		this.xCord = xCord;
	}

	public Double getyCord() {
		return yCord;
	}

	public void setyCord(Double yCord) {
		this.yCord = yCord;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public OffsetDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(OffsetDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}