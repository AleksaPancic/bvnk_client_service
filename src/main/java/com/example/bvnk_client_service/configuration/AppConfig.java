package com.example.bvnk_client_service.configuration;

import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
	//We wont deal with SSL and HTTPS certificates in application, we will use reverse proxy as ngnix server.
	//Empty configuration as we don't need custom @Beans without using DI
	//Next merge will be for security config and permissions
}
