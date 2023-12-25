package com.example.bvnk_client_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class BvnkClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BvnkClientServiceApplication.class, args);
	}

}
