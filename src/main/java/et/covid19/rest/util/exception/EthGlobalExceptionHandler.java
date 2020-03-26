package et.covid19.rest.util.exception;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import et.covid19.rest.swagger.model.ResponseBase;
import et.covid19.rest.util.LogConstants;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class EthGlobalExceptionHandler extends ResponseEntityExceptionHandler{

	protected Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String methodName = "handleHttpMessageNotReadable()";
		log.error(LogConstants.PARAMETER_2, methodName, ex.getMessage());
		return buildResponseEntity(HttpStatus.BAD_REQUEST, headers, null, ex.getMessage(), Arrays.asList("Message not readable."));
	}
	
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(
			MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, 
			WebRequest request) {
		String methodName = "handleMissingServletRequestParameter()";
		log.error(LogConstants.PARAMETER_2, methodName, ex.getMessage());
		String error = "Parameter " + ex.getParameterName() + " is missing";
		return buildResponseEntity(HttpStatus.BAD_REQUEST, headers, null, ex.getMessage(), Arrays.asList(error));
	}
	 
	@ExceptionHandler(value = AccessDeniedException.class)
	public ResponseEntity<Object> handleAccessDeniedException(AccessDeniedException ex) {
		String methodName = "handleAccessDeniedException()";
		log.error(LogConstants.PARAMETER_2, methodName, ex.getMessage());
		return buildResponseEntity(HttpStatus.UNAUTHORIZED, null, null, ex.getMessage(), Arrays.asList(EthExceptionEnums.INSUFFICENT_PERMISSION));
	}
	
	@ExceptionHandler(value = MaxUploadSizeExceededException.class)
	public ResponseEntity<Object> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException ex) {
		String methodName = "handleMaxUploadSizeExceededException()";
		log.error(LogConstants.PARAMETER_2, methodName, ex.getMessage());
		return buildResponseEntity(HttpStatus.BAD_REQUEST, null, null, ex.getMessage(), null);
	}
	
	@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	@ExceptionHandler(value = EthException.class)
	@ResponseBody
	public ResponseEntity<Object> handleEthException(EthException ex) {
		String methodName = "handleEthException()";
		log.error(LogConstants.PARAMETER_2, methodName, ex.getMessage());
		HttpStatus status = ex.getHttpCode();
		Integer internalCode = ex.getInternalCode() > 0 ? ex.getInternalCode() : null;
		return buildResponseEntity(status, null, internalCode, ex.getMessage(), Arrays.asList(ex.getErrors()));
	}
	
	@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResponseEntity<Object> handleGenericException(Exception ex) {
		String methodName = "handleGenericException()";
		log.error(LogConstants.PARAMETER_2, methodName, ex.getMessage());
		return buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, null, null, ex.getMessage(), null);
	}

	private ResponseEntity<Object> buildResponseEntity(HttpStatus status, HttpHeaders headers, Integer internalCode, String message, List<Object> errors) {
		ResponseBase response = new ResponseBase()
				.success(false)
				.message(message)
				.resultCode(internalCode != null ? internalCode : status.value())
				.errors(errors != null
						? errors.stream().filter(Objects::nonNull).map(Objects::toString).collect(Collectors.toList())
						: null);
		
		return new ResponseEntity<>((Object) response, headers, status);
	}
}
