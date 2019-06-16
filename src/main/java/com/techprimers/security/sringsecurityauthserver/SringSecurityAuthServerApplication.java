package com.techprimers.security.sringsecurityauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@SpringBootApplication
public class SringSecurityAuthServerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SringSecurityAuthServerApplication.class, args);
	}

}
