package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class DateOfFirstHealthFacilityVisit {
	private CommentLabel dateFacilityVisitLabel;
	private String dateOfFirstHealthFacilityVisit;
	private String dateOfFirstHealthFacilityVisitOther;

	@JsonProperty("date_facility_visit_label")
	public CommentLabel getDateFacilityVisitLabel() {
		return dateFacilityVisitLabel;
	}

	@JsonProperty("date_facility_visit_label")
	public void setDateFacilityVisitLabel(CommentLabel value) {
		this.dateFacilityVisitLabel = value;
	}

	@JsonProperty("date_of_first_health_facility_visit")
	public String getDateOfFirstHealthFacilityVisit() {
		return dateOfFirstHealthFacilityVisit;
	}

	@JsonProperty("date_of_first_health_facility_visit")
	public void setDateOfFirstHealthFacilityVisit(String value) {
		this.dateOfFirstHealthFacilityVisit = value;
	}

	@JsonProperty("date_of_first_health_facility_visit_other")
	public String getDateOfFirstHealthFacilityVisitOther() {
		return dateOfFirstHealthFacilityVisitOther;
	}

	@JsonProperty("date_of_first_health_facility_visit_other")
	public void setDateOfFirstHealthFacilityVisitOther(String value) {
		this.dateOfFirstHealthFacilityVisitOther = value;
	}
}
