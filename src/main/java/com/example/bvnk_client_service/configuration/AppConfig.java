package com.example.bvnk_client_service.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class AppConfig {

	@Value("${spring.security.csrf.disabled}")
	private boolean csrfDisabled;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		if(csrfDisabled) {
			http.csrf(csrf -> csrf.disable());
		}

		return http.build();
	}

	//We wont deal with SSL and HTTPS certificates in application, we will use reverse proxy as ngnix server.
	//For authentication/authorization we will use JWT.
	//CSRF disabled as no form is being submitted.
}
