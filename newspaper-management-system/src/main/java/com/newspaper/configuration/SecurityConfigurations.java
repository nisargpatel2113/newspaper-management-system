package com.newspaper.configuration;

import java.util.Locale;
import java.util.Map;

import javax.validation.MessageInterpolator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.context.request.WebRequest;

import com.newspaper.service.MyAppUserDetailService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

	@Autowired
	private AppAuthenticationEntryPoint appAuthenicationEntryPoint;

	@Autowired
	private MyAppUserDetailService myAppUserDetailService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, "/api/portal/users").permitAll()
				.antMatchers(HttpMethod.GET, "/api/portal/users/**").hasRole("ADMIN")
				.antMatchers("/api/portal/newspaper/**").hasAnyRole("ADMIN", "USER").antMatchers("/api/portal/admin/**")
				.hasRole("ADMIN").antMatchers("/api/portal/newspaperType/**").hasRole("ADMIN")
				.antMatchers("/api/portal/unitPrice/**").hasAnyRole("ADMIN").and().httpBasic().realmName("MY_APP_REALM")
				.authenticationEntryPoint(appAuthenicationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(myAppUserDetailService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		return provider;
	}

	@Bean
	public ErrorAttributes errorAttributes() {
		return new DefaultErrorAttributes() {
			@Override
			public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
				return super.getErrorAttributes(webRequest, false);
			}
		};
	}

	@Bean
	public MessageInterpolator custom() {
		return new MessageInterpolator() {

			@Override
			public String interpolate(String messageTemplate, Context context, Locale locale) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String interpolate(String messageTemplate, Context context) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

}
