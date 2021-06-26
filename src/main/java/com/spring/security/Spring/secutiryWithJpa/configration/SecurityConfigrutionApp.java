package com.spring.security.Spring.secutiryWithJpa.configration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfigrutionApp extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService userDetailService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		/*auth.inMemoryAuthentication()
		.withUser("suraj")
		.password("{noop}kore")
		.roles("ADMIN")
		.and()
		.withUser("alluser")
		.password("{noop}all")
		.roles("USER");
		*/
		
		auth.userDetailsService(userDetailService);
	}
	
	 protected void configure(HttpSecurity httpSecurity) throws Exception {
		 httpSecurity.authorizeRequests()
		.antMatchers("/security/admin")
		.hasRole("ADMIN")
		 .antMatchers("/security/user")
		 .hasAnyRole("ADMIN","USER")
		 .antMatchers("/security/")
		 .permitAll()
		 
		/* .antMatchers("/**")
		 .hasRole("ADMIN")*/
		 .and()
		 .formLogin();
		 
		 

		 /* .antMatchers("/security/**")
		 .permitAll();*/
		 
		 
		 
		 	 
	 }

	 @Bean
	 public BCryptPasswordEncoder  passwordEncoder() {
	 return new BCryptPasswordEncoder();
	 }
}
