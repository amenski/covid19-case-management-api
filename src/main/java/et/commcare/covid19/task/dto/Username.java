package et.commcare.covid19.task.dto;

import java.util.*;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Username {
	NATIABEBE12_GMAIL_COM, SAMRA_MIT_EDU, USER1;

	@JsonValue
	public String toValue() {
		switch (this) {
		case NATIABEBE12_GMAIL_COM:
			return "natiabebe12@gmail.com";
		case SAMRA_MIT_EDU:
			return "samra@mit.edu";
		case USER1:
			return "user1";
		}
		return null;
	}

	@JsonCreator
	public static Username forValue(String value) throws IOException {
		if (value.equals("natiabebe12@gmail.com"))
			return NATIABEBE12_GMAIL_COM;
		if (value.equals("samra@mit.edu"))
			return SAMRA_MIT_EDU;
		if (value.equals("user1"))
			return USER1;
		throw new IOException("Cannot deserialize Username");
	}
}
