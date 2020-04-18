package com.talent4gig.secureapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired private CustomAuthenticationProvider customAuthenticationProvider;
	@Autowired private BasicAuthenticationEntryPoint basicAuthenticationEntryPoint;

	private static final String[] AUTH_WHITELIST = {"/h2-console/**"};

	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers(AUTH_WHITELIST);
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.headers().xssProtection();
		http.authorizeRequests().antMatchers("/books/**").access("hasRole('USER')");
		http.authorizeRequests().antMatchers("/admin/books/**").access("hasRole('ADMIN')").anyRequest().authenticated()
				.and().httpBasic().authenticationEntryPoint(basicAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.NEVER);
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customAuthenticationProvider);
	}

}
