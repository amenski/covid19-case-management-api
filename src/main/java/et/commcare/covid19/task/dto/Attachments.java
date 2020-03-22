package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Attachments {
	private FormXML formXML;

	@JsonProperty("form.xml")
	public FormXML getFormXML() {
		return formXML;
	}

	@JsonProperty("form.xml")
	public void setFormXML(FormXML value) {
		this.formXML = value;
	}
}
