package com.example.bvnk_client_service.integration.service;

import com.example.bvnk_client_service.DTO.TransactionDTO;
import com.example.bvnk_client_service.service.TransactionService;
import com.example.bvnk_client_service.util.enumeration.TransactionStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class TransactionServiceIntegrationTest {

	private final TransactionService transactionService;

	private static final Long clientId = 1L;

	@Autowired
	public TransactionServiceIntegrationTest(final TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@Test
	public void sendTransactionForCustomer_Success() {
		TransactionDTO transactionDTO = new TransactionDTO();
		transactionDTO.setTransactionStatus(TransactionStatus.CONFIRMED);
		TransactionDTO result = transactionService.sendTransactionForCustomer(clientId, transactionDTO);

		assertThat(result).isNotNull();
	}

	@Test
	public void sendTransactionForCustomer_IllegalArgumentException() {
		assertThrows(IllegalArgumentException.class,
					 () -> transactionService.sendTransactionForCustomer(clientId, null));
	}

}
