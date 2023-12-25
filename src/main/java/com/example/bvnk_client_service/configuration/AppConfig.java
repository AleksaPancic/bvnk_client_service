package com.example.bvnk_client_service.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class AppConfig {
	@Bean
	public RestTemplate reportTemplate() {
		return new RestTemplate();
	}
}
