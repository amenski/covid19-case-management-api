package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class BasicDemo {
	private String houseNumber;
	private String kebele;
	private String kifleKetemaZone;
	private String patientFamilyName;
	private String patientFirstName;
	private String region;
	private String wereda;

	@JsonProperty("house_number")
	public String getHouseNumber() {
		return houseNumber;
	}

	@JsonProperty("house_number")
	public void setHouseNumber(String value) {
		this.houseNumber = value;
	}

	@JsonProperty("kebele")
	public String getKebele() {
		return kebele;
	}

	@JsonProperty("kebele")
	public void setKebele(String value) {
		this.kebele = value;
	}

	@JsonProperty("kifle_ketema_zone")
	public String getKifleKetemaZone() {
		return kifleKetemaZone;
	}

	@JsonProperty("kifle_ketema_zone")
	public void setKifleKetemaZone(String value) {
		this.kifleKetemaZone = value;
	}

	@JsonProperty("patient_family_name")
	public String getPatientFamilyName() {
		return patientFamilyName;
	}

	@JsonProperty("patient_family_name")
	public void setPatientFamilyName(String value) {
		this.patientFamilyName = value;
	}

	@JsonProperty("patient_first_name")
	public String getPatientFirstName() {
		return patientFirstName;
	}

	@JsonProperty("patient_first_name")
	public void setPatientFirstName(String value) {
		this.patientFirstName = value;
	}

	@JsonProperty("region")
	public String getRegion() {
		return region;
	}

	@JsonProperty("region")
	public void setRegion(String value) {
		this.region = value;
	}

	@JsonProperty("wereda")
	public String getWereda() {
		return wereda;
	}

	@JsonProperty("wereda")
	public void setWereda(String value) {
		this.wereda = value;
	}
}
