package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Subcase0 {
	private Subcase0_Case subcase0_Case;

	@JsonProperty("case")
	public Subcase0_Case getSubcase0Case() {
		return subcase0_Case;
	}

	@JsonProperty("case")
	public void setSubcase0Case(Subcase0_Case value) {
		this.subcase0_Case = value;
	}
}
