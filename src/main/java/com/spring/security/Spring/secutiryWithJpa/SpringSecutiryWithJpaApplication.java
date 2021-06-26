package com.spring.security.Spring.secutiryWithJpa;

import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.web.servlet.oauth2.login.OAuth2LoginSecurityMarker;

@SpringBootApplication
@EnableWebSecurity
public class SpringSecutiryWithJpaApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringSecutiryWithJpaApplication.class, args);
		
		System.out.println("Spring security application is runing......");
		System.out.println("This is my fist change uploded on git hub");
	}

}
