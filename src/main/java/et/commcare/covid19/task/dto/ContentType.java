package et.commcare.covid19.task.dto;

import java.util.*;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum ContentType {
	TEXT_XML;

	@JsonValue
	public String toValue() {
		switch (this) {
		case TEXT_XML:
			return "text/xml";
		}
		return null;
	}

	@JsonCreator
	public static ContentType forValue(String value) throws IOException {
		if (value.equals("text/xml"))
			return TEXT_XML;
		throw new IOException("Cannot deserialize ContentType");
	}
}
