package com.example.bvnk_client_service.unit.util;

import com.example.bvnk_client_service.util.function.CreateHeaderFunction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
public class CreateHeaderFunctionTest {

	@InjectMocks
	private CreateHeaderFunction testingInstance;

	@Test
	public void createHeaderFunction_Success() {
		Map<String, Object> result = testingInstance.createHeaders();
		assertThat(result).isNotNull();
	}

}
