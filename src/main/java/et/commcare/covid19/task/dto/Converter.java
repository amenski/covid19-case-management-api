// To use this code, add the following Maven dependency to your project:
//
// Import this package:
//
//     import et.commcare.covid19.task.dto.Converter;
//
// Then you can deserialize a JSON string with
//
//     EtCovid19Case data = Converter.fromJsonString(jsonString);

package et.commcare.covid19.task.dto;

import java.util.*;
import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Converter {
	// Serialize/deserialize helpers

	public static EtCovid19Case fromJsonString(String json) throws IOException {
		return getObjectReader().readValue(json);
	}

	public static String toJsonString(EtCovid19Case obj) throws JsonProcessingException {
		return getObjectWriter().writeValueAsString(obj);
	}

	private static ObjectReader reader;
	private static ObjectWriter writer;

	private static void instantiateMapper() {
		ObjectMapper mapper = new ObjectMapper();
		reader = mapper.readerFor(EtCovid19Case.class);
		writer = mapper.writerFor(EtCovid19Case.class);
	}

	private static ObjectReader getObjectReader() {
		if (reader == null)
			instantiateMapper();
		return reader;
	}

	private static ObjectWriter getObjectWriter() {
		if (writer == null)
			instantiateMapper();
		return writer;
	}
}
