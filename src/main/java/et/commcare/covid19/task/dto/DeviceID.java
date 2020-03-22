package et.commcare.covid19.task.dto;

import java.util.*;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum DeviceID {
	COMMCARE_D5_BFE91_E_A464_48_C4_80_D1_932008_C7378_B, FORMPLAYER;

	@JsonValue
	public String toValue() {
		switch (this) {
		case COMMCARE_D5_BFE91_E_A464_48_C4_80_D1_932008_C7378_B:
			return "commcare_d5bfe91e-a464-48c4-80d1-932008c7378b";
		case FORMPLAYER:
			return "Formplayer";
		}
		return null;
	}

	@JsonCreator
	public static DeviceID forValue(String value) throws IOException {
		if (value.equals("commcare_d5bfe91e-a464-48c4-80d1-932008c7378b"))
			return COMMCARE_D5_BFE91_E_A464_48_C4_80_D1_932008_C7378_B;
		if (value.equals("Formplayer"))
			return FORMPLAYER;
		throw new IOException("Cannot deserialize DeviceID");
	}
}
