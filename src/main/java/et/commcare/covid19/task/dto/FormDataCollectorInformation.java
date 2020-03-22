package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class FormDataCollectorInformation {
	private DataCollectorInformationDataCollectorInformation dataCollectorInformation;
	private DataCollectorInformationList dataCollectorInformationList;

	@JsonProperty("data_collector_information")
	public DataCollectorInformationDataCollectorInformation getDataCollectorInformation() {
		return dataCollectorInformation;
	}

	@JsonProperty("data_collector_information")
	public void setDataCollectorInformation(DataCollectorInformationDataCollectorInformation value) {
		this.dataCollectorInformation = value;
	}

	@JsonProperty("data_collector_information_list")
	public DataCollectorInformationList getDataCollectorInformationList() {
		return dataCollectorInformationList;
	}

	@JsonProperty("data_collector_information_list")
	public void setDataCollectorInformationList(DataCollectorInformationList value) {
		this.dataCollectorInformationList = value;
	}
}
