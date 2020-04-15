package et.covid19.rest.util.exception;

import java.util.function.Supplier;

import org.springframework.http.HttpStatus;

/**
 * a supplier of custom exceptions
 */
public enum EthExceptionEnums implements Supplier<EthException> {

	VALIDATION_EXCEPTION(new EthException(HttpStatus.BAD_REQUEST , 400001, "The input data has a mistake, please try again.")),
	INVALID_OPTION_OR_QUESTION_ID(new EthException(HttpStatus.BAD_REQUEST , 400002, "Invalid questionId or option has been selected.")),
	USER_EXISTS_EXCEPTION(new EthException(HttpStatus.BAD_REQUEST , 400003, "A user with this email already exists.")),
	ADDRESS_EMPTY_EXCEPTION(new EthException(HttpStatus.BAD_REQUEST , 400004, "Address can not be empty.")),
	REGION_EMPTY_EXCEPTION(new EthException(HttpStatus.BAD_REQUEST , 400005, "Region can not be empty.")),
	
	USER_NOT_FOUND(new EthException(HttpStatus.NOT_FOUND , 404001, "User not found.")),
	CASE_NOT_FOUND(new EthException(HttpStatus.NOT_FOUND , 404002, "Case not found.")),
	CONSTANT_NOT_FOUND(new EthException(HttpStatus.NOT_FOUND , 404003, "Attribute or Constant not found.")),
	QUESTIONNIER_NOT_FOUND(new EthException(HttpStatus.NOT_FOUND , 404004, "Questionnier not found.")),
	HEALTH_FACILITY_NOT_FOUND(new EthException(HttpStatus.NOT_FOUND , 404005, "Health facility not found.")),
	DAILY_STAT_NOT_FOUND(new EthException(HttpStatus.NOT_FOUND , 404006, "Daily status empty.")),
	USER_ROLE_NOT_FOUND(new EthException(HttpStatus.NOT_FOUND , 400007, "A user was associated with invalid role.")),
	
	USERNAME_OR_EMAIL_INCORECT(new EthException(HttpStatus.UNAUTHORIZED , 401001, "User name or email incorrect!")),
	AUTHENTICATION_REQUIRED(new EthException(HttpStatus.UNAUTHORIZED , 401002, "Authentication is requred, please try again!")),
	INSUFFICENT_PERMISSION(new EthException(HttpStatus.UNAUTHORIZED , 401003, "Insufficient permission!")),
	
	UNHANDLED_EXCEPTION(new EthException(HttpStatus.INTERNAL_SERVER_ERROR , 500001, "Unhandled exception has occured."));
	
	
	/// ======   ======///
	private EthException e;
	
	/**
	 * needed to put exceptions inside the enums
	 * @param ex
	 */
	private EthExceptionEnums(EthException ex) {
		this.e = ex;
	}
	
	public void message(String message){
		e.setMessage(message);
	}
	/**
	 * gets the EthException instance triggered by the enums
	 * @param e
	 * @return EthException of defined enums
	 */
	@Override
	public EthException get() {
		return e;
	}
}
