package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Confirmed {
	private CommentLabel confirmLabel;
	private CommentLabel confirmedLabel;

	@JsonProperty("confirm_label")
	public CommentLabel getConfirmLabel() {
		return confirmLabel;
	}

	@JsonProperty("confirm_label")
	public void setConfirmLabel(CommentLabel value) {
		this.confirmLabel = value;
	}

	@JsonProperty("confirmed_label")
	public CommentLabel getConfirmedLabel() {
		return confirmedLabel;
	}

	@JsonProperty("confirmed_label")
	public void setConfirmedLabel(CommentLabel value) {
		this.confirmedLabel = value;
	}
}
