package et.commcare.covid19.task.dto;

import java.util.*;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Type {
	DATA;

	@JsonValue
	public String toValue() {
		switch (this) {
		case DATA:
			return "data";
		}
		return null;
	}

	@JsonCreator
	public static Type forValue(String value) throws IOException {
		if (value.equals("data"))
			return DATA;
		throw new IOException("Cannot deserialize Type");
	}
}
