package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class PneumoniaXRay {
	private String pneumoniaXRay;

	@JsonProperty("pneumonia_x_ray")
	public String getPneumoniaXRay() {
		return pneumoniaXRay;
	}

	@JsonProperty("pneumonia_x_ray")
	public void setPneumoniaXRay(String value) {
		this.pneumoniaXRay = value;
	}
}
