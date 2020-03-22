package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class ClinicalCourseComplications {
	private String ards;
	private String emoRequired;
	private HospitalizationRequired hospitalizationRequired;
	private String icuRequired;
	private String mechanicalVentilationRequired;
	private PneumoniaXRay pneumoniaXRay;

	@JsonProperty("ards")
	public String getArds() {
		return ards;
	}

	@JsonProperty("ards")
	public void setArds(String value) {
		this.ards = value;
	}

	@JsonProperty("emo_required")
	public String getEmoRequired() {
		return emoRequired;
	}

	@JsonProperty("emo_required")
	public void setEmoRequired(String value) {
		this.emoRequired = value;
	}

	@JsonProperty("hospitalization_required")
	public HospitalizationRequired getHospitalizationRequired() {
		return hospitalizationRequired;
	}

	@JsonProperty("hospitalization_required")
	public void setHospitalizationRequired(HospitalizationRequired value) {
		this.hospitalizationRequired = value;
	}

	@JsonProperty("icu_required")
	public String getIcuRequired() {
		return icuRequired;
	}

	@JsonProperty("icu_required")
	public void setIcuRequired(String value) {
		this.icuRequired = value;
	}

	@JsonProperty("mechanical_ventilation_required")
	public String getMechanicalVentilationRequired() {
		return mechanicalVentilationRequired;
	}

	@JsonProperty("mechanical_ventilation_required")
	public void setMechanicalVentilationRequired(String value) {
		this.mechanicalVentilationRequired = value;
	}

	@JsonProperty("pneumonia_x_ray")
	public PneumoniaXRay getPneumoniaXRay() {
		return pneumoniaXRay;
	}

	@JsonProperty("pneumonia_x_ray")
	public void setPneumoniaXRay(PneumoniaXRay value) {
		this.pneumoniaXRay = value;
	}
}
