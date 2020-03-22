package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class ExposedByProducts {
	private String patientExposedByProducts;

	@JsonProperty("patient_exposed_by_products")
	public String getPatientExposedByProducts() {
		return patientExposedByProducts;
	}

	@JsonProperty("patient_exposed_by_products")
	public void setPatientExposedByProducts(String value) {
		this.patientExposedByProducts = value;
	}
}
