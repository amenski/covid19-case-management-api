package et.commcare.covid19.task.dto;

import java.util.*;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum CommentLabel {
	EMPTY, OK;

	@JsonValue
	public String toValue() {
		switch (this) {
		case EMPTY:
			return "";
		case OK:
			return "OK";
		}
		return null;
	}

	@JsonCreator
	public static CommentLabel forValue(String value) throws IOException {
		if (value.equals(""))
			return EMPTY;
		if (value.equals("OK"))
			return OK;
		throw new IOException("Cannot deserialize CommentLabel");
	}
}
