package et.covid19.rest.util;

import et.covid19.rest.util.exception.EthException;

public class EthConstants {

	public static final String CONST_TYPE_TEST_RESULT = "TEST_RESULT";
	public static final String CONST_TYPE_IDENTIFIED_BY = "IDENTIFIED_BY";
	public static final String CONST_TYPE_QUESTIONNIER_CAT = "QUESTIONNIER_CATEGORY";
	
	private EthConstants() throws EthException {
		throw new EthException("Utility class.");
	}
}
