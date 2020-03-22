package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Ards {
	private String acuteRespiratoryDistressSyndrome;

	@JsonProperty("acute_respiratory_distress_syndrome")
	public String getAcuteRespiratoryDistressSyndrome() {
		return acuteRespiratoryDistressSyndrome;
	}

	@JsonProperty("acute_respiratory_distress_syndrome")
	public void setAcuteRespiratoryDistressSyndrome(String value) {
		this.acuteRespiratoryDistressSyndrome = value;
	}
}
