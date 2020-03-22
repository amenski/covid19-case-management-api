package et.commcare.covid19.task.dto;

import java.util.*;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Domain {
	ETHIOCOVID19;

	@JsonValue
	public String toValue() {
		switch (this) {
		case ETHIOCOVID19:
			return "ethiocovid19";
		}
		return null;
	}

	@JsonCreator
	public static Domain forValue(String value) throws IOException {
		if (value.equals("ethiocovid19"))
			return ETHIOCOVID19;
		throw new IOException("Cannot deserialize Domain");
	}
}
