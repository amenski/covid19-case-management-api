package et.covid19.rest.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import et.covid19.rest.services.auth.UserDetailserviceImpl;


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

	private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	private final UserDetailserviceImpl jwtUserDetailsService;
	private final JwtRequestFilter jwtRequestFilter;
	
	public SecurityConfig(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, UserDetailserviceImpl jwtUserDetailsService, JwtRequestFilter jwtRequestFilter) {
		this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
		this.jwtUserDetailsService = jwtUserDetailsService;
		this.jwtRequestFilter = jwtRequestFilter;
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		// configure AuthenticationManager so that it knows from where to load user for matching credentials
		// Use BCryptPasswordEncoder
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//authorizeRequests() order is important
		http
		.csrf().disable()
		.authorizeRequests().antMatchers("/v1/api/**").authenticated()
		.and()
		.authorizeRequests().antMatchers("/**").permitAll()
		.and()
		.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);;
	}
	
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider(){
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(jwtUserDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		
		return provider;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}
	
}
