package et.covid19.rest.util;

import et.covid19.rest.util.exception.EthException;

public class EthConstants {

	public static final String CONST_TYPE_TEST_RESULT = "TEST_RESULT";
	public static final String CONST_TYPE_IDENTIFIED_BY = "IDENTIFIED_BY";
	public static final String CONST_TYPE_QUESTIONNIER_CAT = "QUESTIONNIER_CATEGORY";
	public static final String CONST_TYPE_STATUS = "STATUS";
	public static final String RUMOR_REPORT_STATUS = "RUMOR_STATUS";
	

	public static final Integer CONST_TEST_PENDING = 1001;
	public static final Integer CONST_IDENTIFIED_BY_CLINICAL_EVAL = 1020;
	public static final Integer CONST_STATUS_NA = 1064;
	public static final Integer CONST_RUMOR_PENDING = 1080;
	
	// auth
	public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5*60*60;
	public static final String SIGNING_KEY = "covid19";
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	
	public static final Integer ROLE_USER_ID = 1;
	
	private EthConstants() throws EthException {
		throw new EthException("Utility class.");
	}
}
