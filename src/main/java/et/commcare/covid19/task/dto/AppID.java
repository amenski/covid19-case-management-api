package et.commcare.covid19.task.dto;

import java.util.*;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum AppID {
	THE_63_B3_F8_B41_C6143_E08_DE62607225072_CE, THE_7_C00659_A2_A5_F4_CE8_AA635_C879_F54_E136;

	@JsonValue
	public String toValue() {
		switch (this) {
		case THE_63_B3_F8_B41_C6143_E08_DE62607225072_CE:
			return "63b3f8b41c6143e08de62607225072ce";
		case THE_7_C00659_A2_A5_F4_CE8_AA635_C879_F54_E136:
			return "7c00659a2a5f4ce8aa635c879f54e136";
		}
		return null;
	}

	@JsonCreator
	public static AppID forValue(String value) throws IOException {
		if (value.equals("63b3f8b41c6143e08de62607225072ce"))
			return THE_63_B3_F8_B41_C6143_E08_DE62607225072_CE;
		if (value.equals("7c00659a2a5f4ce8aa635c879f54e136"))
			return THE_7_C00659_A2_A5_F4_CE8_AA635_C879_F54_E136;
		throw new IOException("Cannot deserialize AppID");
	}
}
