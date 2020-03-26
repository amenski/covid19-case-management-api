package et.covid19.rest.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import et.covid19.rest.util.LogConstants;

/**
 * In cooperation with an aspect, this is a marker to log method inputs
 * 
 * @author Amanuel_SHIFERAW
 *
 */
@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EthLoggable {
	String format() default LogConstants.PARAMETER_2;
	String[] exclusions() default "";
}
