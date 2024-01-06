package com.example.bvnk_client_service.integration.controller;

import com.example.bvnk_client_service.DTO.TransactionDTO;
import com.example.bvnk_client_service.controller.TransactionController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class TransactionControllerIntegrationTest {

	private final TransactionController transactionController;
	private TransactionDTO transaction;

	private static final Long clientId = 1L;

	@BeforeEach
	public void setUp() {
		transaction = new TransactionDTO();
	}

	@Autowired
	public TransactionControllerIntegrationTest(TransactionController transactionController) {
		this.transactionController = transactionController;
	}

	@Test
	public void sendTransactionToCustomer_Success() {
		final TransactionDTO result = transactionController.sendTransactionForCustomer(clientId, transaction).getBody();
		assertThat(result).isNotNull();
		assertThat(result).isInstanceOf(TransactionDTO.class);
	}

	@Test
	public void sendTransactionToCustomer_Failure_ShouldThrowIllegalArgumentException() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
														  () -> transactionController.sendTransactionForCustomer(null,
																												 transaction));
		assertThat(exception.getMessage()).contains("Could not send transaction for client");
	}

	@Test
	public void cancelTransactionToCustomer_Success() {
		final TransactionDTO result = transactionController.cancelTransactionForCustomer(clientId, transaction).getBody();
		assertThat(result).isNotNull();
		assertThat(result).isInstanceOf(TransactionDTO.class);
	}

	@Test
	public void cancelTransactionToCustomer_Failure_ShouldThrowIllegalArgumentException() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
														  () -> transactionController.cancelTransactionForCustomer(null,
																												   transaction));
		assertThat(exception.getMessage()).contains("Invalid client id provided for transaction");
	}

}
