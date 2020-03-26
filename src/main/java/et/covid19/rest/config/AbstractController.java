package et.covid19.rest.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import et.covid19.rest.swagger.model.ResponseBase;
import et.covid19.rest.util.LogConstants;
import et.covid19.rest.util.exception.EthException;
import et.covid19.rest.util.exception.EthExceptionEnums;

public abstract class AbstractController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@SuppressWarnings("unchecked")
	public <T extends ResponseBase> T fillSuccessResponse(T response) {
		 if(response == null){
			 response = (T) getNewInstance(response.getClass());
		 }
		response.success(true);
		response.resultCode(LogConstants.SUCCESS);
		response.message("");
		response.errors(null);

		return response;
	}

	public <T extends ResponseBase> T fillFailResponseEthException(Class<T> response, EthException e){
		T res = getNewInstance(response);
		res.success(false);
		res.resultCode(e.getInternalCode());
		res.message(e.getMessage() != null ? e.getMessage() : "");
		res.errors(e.getErrors());
		
		return res;
	}
	
	public <T extends ResponseBase> T fillFailResponseGeneric(Class<T> responseClass){
		T response = getNewInstance(responseClass);
		response.success(false);
		response.resultCode(EthExceptionEnums.UNHANDLED_EXCEPTION.get().getInternalCode());
		response.message(EthExceptionEnums.UNHANDLED_EXCEPTION.get().getMessage());
		response.errors(null);
		
		return response;
	}
	
	@SuppressWarnings("unchecked")
	private <T> T getNewInstance(Class<T> clazz){
		T newInstance;
		try {
			newInstance = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			newInstance = (T) new ResponseBase();
		}
		return newInstance;
	}
}
