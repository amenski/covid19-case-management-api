package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class PneumoniaByChestXRay {
	private String pneumoniaByChestXRay;

	@JsonProperty("pneumonia_by_chest_x-ray")
	public String getPneumoniaByChestXRay() {
		return pneumoniaByChestXRay;
	}

	@JsonProperty("pneumonia_by_chest_x-ray")
	public void setPneumoniaByChestXRay(String value) {
		this.pneumoniaByChestXRay = value;
	}
}
