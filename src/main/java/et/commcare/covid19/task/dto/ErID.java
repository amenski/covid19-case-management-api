package et.commcare.covid19.task.dto;

import java.util.*;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum ErID {
	AEA5_D60_A9_E674_C5_BB4_E9913852_E331_D5, E3557_A8_E3_C1_E444_F6_F22894_ED9_ED4497,
	THE_12068_D4_A988_A1471685497869_CE6458_B;

	@JsonValue
	public String toValue() {
		switch (this) {
		case AEA5_D60_A9_E674_C5_BB4_E9913852_E331_D5:
			return "aea5d60a9e674c5bb4e9913852e331d5";
		case E3557_A8_E3_C1_E444_F6_F22894_ED9_ED4497:
			return "e3557a8e3c1e444f6f22894ed9ed4497";
		case THE_12068_D4_A988_A1471685497869_CE6458_B:
			return "12068d4a988a1471685497869ce6458b";
		}
		return null;
	}

	@JsonCreator
	public static ErID forValue(String value) throws IOException {
		if (value.equals("aea5d60a9e674c5bb4e9913852e331d5"))
			return AEA5_D60_A9_E674_C5_BB4_E9913852_E331_D5;
		if (value.equals("e3557a8e3c1e444f6f22894ed9ed4497"))
			return E3557_A8_E3_C1_E444_F6_F22894_ED9_ED4497;
		if (value.equals("12068d4a988a1471685497869ce6458b"))
			return THE_12068_D4_A988_A1471685497869_CE6458_B;
		throw new IOException("Cannot deserialize ErID");
	}
}
