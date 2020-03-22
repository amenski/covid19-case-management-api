package et.commcare.covid19.task.dto;

import java.util.*;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum CaseType {
	CONTACT, COVID_19__CASE;

	@JsonValue
	public String toValue() {
		switch (this) {
		case CONTACT:
			return "contact";
		case COVID_19__CASE:
			return "covid_19_case";
		}
		return null;
	}

	@JsonCreator
	public static CaseType forValue(String value) throws IOException {
		if (value.equals("contact"))
			return CONTACT;
		if (value.equals("covid_19_case"))
			return COVID_19__CASE;
		throw new IOException("Cannot deserialize CaseType");
	}
}
