package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class AgeComponentMath {
	private String dobMonth;
	private String inDob;
	private String inToday;
	private String outDobMonthsOld;
	private String outDobYearsOld;
	private String todayMonths;

	@JsonProperty("dob_month")
	public String getDobMonth() {
		return dobMonth;
	}

	@JsonProperty("dob_month")
	public void setDobMonth(String value) {
		this.dobMonth = value;
	}

	@JsonProperty("in_dob")
	public String getInDob() {
		return inDob;
	}

	@JsonProperty("in_dob")
	public void setInDob(String value) {
		this.inDob = value;
	}

	@JsonProperty("in_today")
	public String getInToday() {
		return inToday;
	}

	@JsonProperty("in_today")
	public void setInToday(String value) {
		this.inToday = value;
	}

	@JsonProperty("out_dob_months_old")
	public String getOutDobMonthsOld() {
		return outDobMonthsOld;
	}

	@JsonProperty("out_dob_months_old")
	public void setOutDobMonthsOld(String value) {
		this.outDobMonthsOld = value;
	}

	@JsonProperty("out_dob_years_old")
	public String getOutDobYearsOld() {
		return outDobYearsOld;
	}

	@JsonProperty("out_dob_years_old")
	public void setOutDobYearsOld(String value) {
		this.outDobYearsOld = value;
	}

	@JsonProperty("today_months")
	public String getTodayMonths() {
		return todayMonths;
	}

	@JsonProperty("today_months")
	public void setTodayMonths(String value) {
		this.todayMonths = value;
	}
}
