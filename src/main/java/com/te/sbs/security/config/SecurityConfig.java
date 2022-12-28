package com.te.sbs.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserDetailsService userDetailsService;
//	private final SecurityFilter securityFilter;

	private final String USER = "USER";
	private final String ADMIN = "ADMIN";

	/*
	 * This method is used to create the bean of AuthenticationManager, hence having
	 * the annotation @Bean. As the name suggest, it manages the authentication
	 * using username and password. The authenticationManager() method calls the
	 * configure(...) methods for validation username and password, and also
	 * checking the authority of a user to access a certain api.
	 */
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	/*
	 * This method is used by AuthenticationManager, and it needs UserDetailsService
	 * type object and PasswordEncoder type object. UserDetailsService type object
	 * is used to fetch the user data from the database in the form of UserDetails
	 * and PasswordEncoder type object is used to encode the raw password received
	 * while logging-in.
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	/*
	 * This method is used to deal with roles and api path. Here we configure what
	 * api is accessible with what role of user. We are also disabling CSRF
	 * protection so that we can test application using postman. We are also
	 * defining the public apis and apis that need authentication before use.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
		//http.authorizeRequests().antMatchers("/defaultuser/**").permitAll().anyRequest().authenticated();
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		http.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
	}

}
