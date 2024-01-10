package com.example.bvnk_client_service.integration.util;

import com.example.bvnk_client_service.util.function.CreateHeaderFunction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class CreateHeaderFunctionIntegrationTest {

	private final CreateHeaderFunction createHeaderFunction;

	@Autowired
	public CreateHeaderFunctionIntegrationTest(final CreateHeaderFunction createHeaderFunction) {
		this.createHeaderFunction = createHeaderFunction;
	}

/*	@Test
	public void createHeaders() {
        Map<String, Object> headers = createHeaderFunction.createHeaders();
        assertThat(headers).isNotNull();
    }*/

}
