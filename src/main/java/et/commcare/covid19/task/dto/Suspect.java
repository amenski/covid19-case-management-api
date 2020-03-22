package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Suspect {
	private CommentLabel copy1OfSuspectedLabel;
	private CommentLabel suspectedLabel;

	@JsonProperty("copy-1-of-suspected_label")
	public CommentLabel getCopy1OfSuspectedLabel() {
		return copy1OfSuspectedLabel;
	}

	@JsonProperty("copy-1-of-suspected_label")
	public void setCopy1OfSuspectedLabel(CommentLabel value) {
		this.copy1OfSuspectedLabel = value;
	}

	@JsonProperty("suspected_label")
	public CommentLabel getSuspectedLabel() {
		return suspectedLabel;
	}

	@JsonProperty("suspected_label")
	public void setSuspectedLabel(CommentLabel value) {
		this.suspectedLabel = value;
	}
}
