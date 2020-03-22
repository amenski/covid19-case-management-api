package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class PatientSymptoms {
	private TravelInformation travelInformation;
	private DateOfFirstSymptomOnset dateOfFirstSymptomOnset;
	private Symptoms symptoms;
	private DateOfFirstHealthFacilityVisit dateOfFirstHealthFacilityVisit;
	private DateOfFirstSymptom dateOfFirstSymptom;
	private Fever fever;
	private TotalHealthFacilitiesVisitedToDate totalHealthFacilitiesVisitedToDate;

	@JsonProperty("Travel_Information")
	public TravelInformation getTravelInformation() {
		return travelInformation;
	}

	@JsonProperty("Travel_Information")
	public void setTravelInformation(TravelInformation value) {
		this.travelInformation = value;
	}

	@JsonProperty("date_of_first_symptom_onset")
	public DateOfFirstSymptomOnset getDateOfFirstSymptomOnset() {
		return dateOfFirstSymptomOnset;
	}

	@JsonProperty("date_of_first_symptom_onset")
	public void setDateOfFirstSymptomOnset(DateOfFirstSymptomOnset value) {
		this.dateOfFirstSymptomOnset = value;
	}

	@JsonProperty("symptoms")
	public Symptoms getSymptoms() {
		return symptoms;
	}

	@JsonProperty("symptoms")
	public void setSymptoms(Symptoms value) {
		this.symptoms = value;
	}

	@JsonProperty("date_of_first_health_facility_visit")
	public DateOfFirstHealthFacilityVisit getDateOfFirstHealthFacilityVisit() {
		return dateOfFirstHealthFacilityVisit;
	}

	@JsonProperty("date_of_first_health_facility_visit")
	public void setDateOfFirstHealthFacilityVisit(DateOfFirstHealthFacilityVisit value) {
		this.dateOfFirstHealthFacilityVisit = value;
	}

	@JsonProperty("date_of_first_symptom")
	public DateOfFirstSymptom getDateOfFirstSymptom() {
		return dateOfFirstSymptom;
	}

	@JsonProperty("date_of_first_symptom")
	public void setDateOfFirstSymptom(DateOfFirstSymptom value) {
		this.dateOfFirstSymptom = value;
	}

	@JsonProperty("fever")
	public Fever getFever() {
		return fever;
	}

	@JsonProperty("fever")
	public void setFever(Fever value) {
		this.fever = value;
	}

	@JsonProperty("total_health_facilities_visited_to_date")
	public TotalHealthFacilitiesVisitedToDate getTotalHealthFacilitiesVisitedToDate() {
		return totalHealthFacilitiesVisitedToDate;
	}

	@JsonProperty("total_health_facilities_visited_to_date")
	public void setTotalHealthFacilitiesVisitedToDate(TotalHealthFacilitiesVisitedToDate value) {
		this.totalHealthFacilitiesVisitedToDate = value;
	}
}
