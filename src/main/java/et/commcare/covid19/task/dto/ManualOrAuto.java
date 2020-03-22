package et.commcare.covid19.task.dto;

import java.util.*;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum ManualOrAuto {
	GENERATE;

	@JsonValue
	public String toValue() {
		switch (this) {
		case GENERATE:
			return "generate";
		}
		return null;
	}

	@JsonCreator
	public static ManualOrAuto forValue(String value) throws IOException {
		if (value.equals("generate"))
			return GENERATE;
		throw new IOException("Cannot deserialize ManualOrAuto");
	}
}
