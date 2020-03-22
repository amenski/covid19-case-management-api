package et.commcare.covid19.task.dto;

import java.util.*;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum PatientCaseStatus {
	CONFIRMED, SUSPECTED;

	@JsonValue
	public String toValue() {
		switch (this) {
		case CONFIRMED:
			return "confirmed";
		case SUSPECTED:
			return "suspected";
		}
		return null;
	}

	@JsonCreator
	public static PatientCaseStatus forValue(String value) throws IOException {
		if (value.equals("confirmed"))
			return CONFIRMED;
		if (value.equals("suspected"))
			return SUSPECTED;
		throw new IOException("Cannot deserialize PatientCaseStatus");
	}
}
