package com.example.bvnk_client_service.unit.service;

import com.example.bvnk_client_service.DTO.TransactionDTO;
import com.example.bvnk_client_service.api.TransactionServiceAPI;
import com.example.bvnk_client_service.service.impl.DefaultTransactionService;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DefaultTransactionServiceTest {

	@InjectMocks
	private DefaultTransactionService testingInstance;

	@Mock
	private TransactionServiceAPI transactionServiceAPI;

	@Mock
	private CreateHeaderFunction createHeaderFunction;

	@Mock
	private TransactionDTO transactionDTO;

	@Mock
	private ResponseEntity<TransactionDTO> responseEntity;

	private static final Long clientId = 1L;

	@BeforeTestClass
	public void setUp() {
		when(createHeaderFunction.createHeaders()).thenReturn(ArgumentMatchers.any(Map.class));
	}

	@Test
	public void sendTransactionForCustomer_Success() {
		when(transactionServiceAPI.addTransactionForClient(createHeaderFunction.createHeaders(), clientId,
														   transactionDTO)).thenReturn(responseEntity);
		when(responseEntity.getStatusCode()).thenReturn(HttpStatus.OK);
		when(responseEntity.getBody()).thenReturn(transactionDTO);

		TransactionDTO result = testingInstance.sendTransactionForCustomer(clientId, transactionDTO);

		assertThat(result).isEqualTo(transactionDTO);

	}

	@Test
	public void sendTransactionForCustomer_Failure() {
		when(transactionServiceAPI.addTransactionForClient(createHeaderFunction.createHeaders(), clientId,
														   transactionDTO)).thenReturn(responseEntity);
		when(responseEntity.getStatusCode()).thenReturn(HttpStatus.BAD_REQUEST);

		IllegalStateException exception = assertThrows(IllegalStateException.class,
													   () -> testingInstance.sendTransactionForCustomer(clientId,
																										transactionDTO));

		assertThat(exception.getMessage()).contains("Error sending transaction for client");
	}

	@Test
	public void cancelTransactionForCustomer_Success() {
		when(transactionServiceAPI.cancelTransactionForClient(createHeaderFunction.createHeaders(), clientId,
															  transactionDTO)).thenReturn(responseEntity);
		when(responseEntity.getStatusCode()).thenReturn(HttpStatus.OK);
		when(responseEntity.getBody()).thenReturn(transactionDTO);

		TransactionDTO result = testingInstance.cancelTransactionForCustomer(clientId, transactionDTO);

		assertThat(result).isEqualTo(transactionDTO);
	}

}
