package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class TotalHealthFacilitiesVisitedToDate {
	private String totalHealthFacilitiesVisitedToDateOther;

	@JsonProperty("total_health_facilities_visited_to_date_other")
	public String getTotalHealthFacilitiesVisitedToDateOther() {
		return totalHealthFacilitiesVisitedToDateOther;
	}

	@JsonProperty("total_health_facilities_visited_to_date_other")
	public void setTotalHealthFacilitiesVisitedToDateOther(String value) {
		this.totalHealthFacilitiesVisitedToDateOther = value;
	}
}
