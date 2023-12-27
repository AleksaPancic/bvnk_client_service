package com.example.bvnk_client_service.util.function;

import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class CreateHeaderFunction {
	public Map<String, Object> createHeaders() {
		return Map.of("X_AUTHORIZATION", "testAuthForNow, Need JWT service", "CONTENT_TYPE", "testContentType for now");
	}

}
