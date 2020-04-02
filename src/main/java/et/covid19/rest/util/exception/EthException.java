package et.covid19.rest.util.exception;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

public class EthException extends Exception {
	private static final long serialVersionUID = -5464526854597284442L;

	private HttpStatus httpCode;
	private int internalCode;
	private String message;
	private List<String> errors;
	
	public EthException(String message) {
		super();
		this.message = message;
	}

	public EthException(HttpStatus httpCode, int internalCode, String message) {
		super();
		this.httpCode = httpCode;
		this.internalCode = internalCode;
		this.message = message;
	}
	
	public EthException(HttpStatus httpCode, String message, List<String> errors) {
		super();
		this.httpCode = httpCode;
		this.message = message;
		this.errors = errors;
	}

	public EthException(HttpStatus httpCode, int internalCode, String message, List<String> errors) {
		super();
		this.httpCode = httpCode;
		this.internalCode = internalCode;
		this.message = message;
		this.errors = errors;
	}
	
	public HttpStatus getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(HttpStatus httpCode) {
		this.httpCode = httpCode;
	}

	public int getInternalCode() {
		return internalCode;
	}

	public void setInternalCode(int internalCode) {
		this.internalCode = internalCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		if(errors == null)
			return new ArrayList<>();
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public EthException message(String newMessage) {
		if(!StringUtils.isBlank(newMessage)) {
			this.message = newMessage;
		}
		return this;
	}
}
