package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Labels {
	private CommentLabel followUpLabel;
	private CommentLabel formCompletionLabel;
	private CommentLabel ifThisIsTheFirstContactRecordedForThisCovid19_CaseThisCovid19_;
	private CommentLabel inOrderToSelectThisNewContactInTheContactsMenuPleaseSelectThe;

	@JsonProperty("follow_up_label")
	public CommentLabel getFollowUpLabel() {
		return followUpLabel;
	}

	@JsonProperty("follow_up_label")
	public void setFollowUpLabel(CommentLabel value) {
		this.followUpLabel = value;
	}

	@JsonProperty("form_completion_label")
	public CommentLabel getFormCompletionLabel() {
		return formCompletionLabel;
	}

	@JsonProperty("form_completion_label")
	public void setFormCompletionLabel(CommentLabel value) {
		this.formCompletionLabel = value;
	}

	@JsonProperty("if_this_is_the_first_contact_recorded_for_this_covid-19_case_this_covid-19_")
	public CommentLabel getIfThisIsTheFirstContactRecordedForThisCovid19CaseThisCovid19() {
		return ifThisIsTheFirstContactRecordedForThisCovid19_CaseThisCovid19_;
	}

	@JsonProperty("if_this_is_the_first_contact_recorded_for_this_covid-19_case_this_covid-19_")
	public void setIfThisIsTheFirstContactRecordedForThisCovid19CaseThisCovid19(CommentLabel value) {
		this.ifThisIsTheFirstContactRecordedForThisCovid19_CaseThisCovid19_ = value;
	}

	@JsonProperty("in_order_to_select_this_new_contact_in_the_contacts_menu_please_select_the_")
	public CommentLabel getInOrderToSelectThisNewContactInTheContactsMenuPleaseSelectThe() {
		return inOrderToSelectThisNewContactInTheContactsMenuPleaseSelectThe;
	}

	@JsonProperty("in_order_to_select_this_new_contact_in_the_contacts_menu_please_select_the_")
	public void setInOrderToSelectThisNewContactInTheContactsMenuPleaseSelectThe(CommentLabel value) {
		this.inOrderToSelectThisNewContactInTheContactsMenuPleaseSelectThe = value;
	}
}
