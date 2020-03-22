package et.commcare.covid19.task.dto;

import java.util.*;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum HasContacts {
	YES;

	@JsonValue
	public String toValue() {
		switch (this) {
		case YES:
			return "yes";
		}
		return null;
	}

	@JsonCreator
	public static HasContacts forValue(String value) throws IOException {
		if (value.equals("yes"))
			return YES;
		throw new IOException("Cannot deserialize HasContacts");
	}
}
