package com.example.bvnk_client_service.unit.service;

import com.example.bvnk_client_service.DTO.HistoryDTO;
import com.example.bvnk_client_service.api.HistoryServiceAPI;
import com.example.bvnk_client_service.service.impl.DefaultHistoryService;
import com.example.bvnk_client_service.util.function.CreateHeaderFunction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DefaultHistoryServiceTest {

	@InjectMocks
	private DefaultHistoryService testedInstance;

	@Mock
	private HistoryServiceAPI historyServiceAPI;

	@Mock
	private CreateHeaderFunction createHeaderFunction;

	@Mock
	private HistoryDTO historyDTO;

	@Mock
	private ResponseEntity<HistoryDTO> response;

	private static final Long clientId = 1L;

	@BeforeTestClass
	public void setUp() {
		when(createHeaderFunction.createHeaders()).thenReturn(ArgumentMatchers.any(Map.class));
	}

	@Test
	public void testGetHistoryForClient_Success() {
		when(historyServiceAPI.getHistoryForCustomer(createHeaderFunction.createHeaders(), clientId)).thenReturn(response);
		when(response.getStatusCode()).thenReturn(HttpStatus.OK);

		HistoryDTO result = testedInstance.getHistoryForClient(clientId);

		assertThat(result).isEqualTo(response.getBody());
	}

	@Test
	public void shouldThrowException_WhenResponseIsNotSuccessful() {
		when(historyServiceAPI.getHistoryForCustomer(createHeaderFunction.createHeaders(), clientId)).thenReturn(
				new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));

		IllegalStateException exception = org.junit.jupiter.api.Assertions.assertThrows(
				IllegalStateException.class,
				() -> testedInstance.getHistoryForClient(clientId)
		);
		assertThat(exception.getMessage()).contains("Error fetching history for client:");
	}

}
