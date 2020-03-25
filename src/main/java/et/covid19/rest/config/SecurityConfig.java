package et.covid19.rest.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


/**
 * 
 * <br/>Note: Web and Method security might be used together specially when we have different roles/rights 
 * specific to some functionalities only. e.g. assume that a user is able to edit, but not delete
 * an object/entity. Unless method security({@code @PreAuthorize} and the like) is specified, it will be 
 * possible to do both.
 * 
 * @see https://spring.io/guides/topicals/spring-security-architecture
 * @author Aman
 *
 */

@Configuration
@EnableWebSecurity
@Order(SecurityProperties.BASIC_AUTH_ORDER - 10)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// http://blog.florian-hopf.de/2017/08/spring-security.html
	// configure(WebSecurity web) ... can be added to ignore checking on some resources like files
	// and then `web.ignoring().antMatchers("/resources/**");`
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//authorizeRequests() order is important
		http
		.csrf().disable()
		.authorizeRequests().antMatchers("/**").permitAll()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
