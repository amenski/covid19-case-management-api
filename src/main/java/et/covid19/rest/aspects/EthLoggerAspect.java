package et.covid19.rest.aspects;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.util.LogConstants;
import et.covid19.rest.util.LogConstants.LogLevel;


/**
 * Implements how to log methods annotated as {@code EthLoggable}
 * 
 * @author Aman
 *
 */

@Aspect
@Component
public class EthLoggerAspect {

	Logger logger = LoggerFactory.getLogger(EthLoggerAspect.class);
	
	@Autowired
	private Environment enviroment;
	
	//The argument ProceedingJoinPoint will be an executing method which has been annotated with @Loggable. 
	@Around("@annotation(et.covid19.rest.annotations.EthLoggable)") //or add EthLogger as a param with jointPoint
	public Object loggerInterceptor(ProceedingJoinPoint jointPoint) throws Throwable{
		List<String> arguments = new ArrayList<>(); 
		String declaringMethod = EthLoggerAspect.class.getSimpleName();
		Object proceed = null;
		try{
			MethodSignature methodSignature = (MethodSignature) jointPoint.getSignature();
			Method method = methodSignature.getMethod();
			declaringMethod = methodSignature.getDeclaringType().getSimpleName() + "." + method.getName() + "()"; //like clazz.methodName()
			
			//argument name and value
			//TODO if the inputs are objects, print data properly
			String[] argumentNames = methodSignature.getParameterNames();
			Object[] methodArguments = jointPoint.getArgs();
			
			//get exclusions
			EthLoggable loggable = method.getAnnotation(EthLoggable.class);
			String[] exclusions = loggable.exclusions();
			
			//add name and value of each parameter
			for(int i=0; i < methodArguments.length; i++){
				if(Arrays.asList(exclusions).contains(argumentNames[i])){
					arguments.add(argumentNames[i] + " = " + "****");
					continue;
				}
				arguments.add(argumentNames[i] + " = " + methodArguments[i]);
			}
			
			//log
			log(declaringMethod, LogLevel.INFO, loggable.format(), LogConstants.METHOD_START);
			log(declaringMethod, LogLevel.INFO, loggable.format(), arguments.toString());
			
			proceed = jointPoint.proceed();
		}catch (Exception e) {
			if(isDevEnv()) {
				log(declaringMethod,  LogLevel.ERROR, "{} {}",  e.toString());
			}
			log(declaringMethod,  LogLevel.ERROR, "{} {}",  e.getMessage());
			throw e; //should not swallow the thrown exception
		}finally {
			log(declaringMethod,  LogLevel.INFO, "{} {}", LogConstants.METHOD_END);
		}
		return proceed;
	}
	
	public void log(String declaringMethod, LogLevel level,String format, String message) {
		
		switch (level) {
			case INFO:
				logger.info(format, declaringMethod, message);
				break;
			case DEBUG:
				logger.debug(format, declaringMethod, message);
				break;
			case WARNING:
				logger.warn(format, declaringMethod, message);
				break;
			case ERROR:
				logger.error(format, declaringMethod, message);
				break;
			default:
				break;
		}
	}
	
	private boolean isDevEnv() {
		for(String env : enviroment.getActiveProfiles()) {
			if(StringUtils.equalsAny(env, "dev", "development")) 
				return true;
		}
		
		return false;
	}
}
