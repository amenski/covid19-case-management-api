package et.covid19.rest.util;

import et.covid19.rest.util.exception.EthException;

public class LogConstants {

	public static final String PARAMETER_2 = "{} {}";
	public static final String PARAMETER_3 = "{} {} {}";
	public static final String METHOD_START = " method start.";
	public static final String METHOD_END = " method end.";
	public static final String INPUT_PARAMETER = " input parameter ";
	
	public static final String UUID_KEY = "UUID";
	public static final String TRANSACTION_ID_KEY = "TRANSACTION_ID_KEY";
	
	public static final int SUCCESS = 0;
	public static final int FAIL = 1;
	
	//log levels
	public enum LogLevel {
		INFO, DEBUG, WARNING, ERROR;
	}
	
	private LogConstants() throws EthException {
		throw new EthException("Utility class.");
	}
}
