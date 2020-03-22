package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class FestivalMassGathering {
	private String attendedFestivalOrMassGathering;
	private String festivalMassGatheringSpecify;

	@JsonProperty("attended_festival_or_mass_gathering")
	public String getAttendedFestivalOrMassGathering() {
		return attendedFestivalOrMassGathering;
	}

	@JsonProperty("attended_festival_or_mass_gathering")
	public void setAttendedFestivalOrMassGathering(String value) {
		this.attendedFestivalOrMassGathering = value;
	}

	@JsonProperty("festival_mass_gathering_specify")
	public String getFestivalMassGatheringSpecify() {
		return festivalMassGatheringSpecify;
	}

	@JsonProperty("festival_mass_gathering_specify")
	public void setFestivalMassGatheringSpecify(String value) {
		this.festivalMassGatheringSpecify = value;
	}
}
