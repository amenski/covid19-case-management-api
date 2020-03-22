package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Index {
	private Parent parent;

	@JsonProperty("parent")
	public Parent getParent() {
		return parent;
	}

	@JsonProperty("parent")
	public void setParent(Parent value) {
		this.parent = value;
	}
}
