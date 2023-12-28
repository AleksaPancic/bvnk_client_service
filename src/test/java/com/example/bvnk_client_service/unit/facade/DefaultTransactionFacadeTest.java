package com.example.bvnk_client_service.unit.facade;

import com.example.bvnk_client_service.DTO.TransactionDTO;
import com.example.bvnk_client_service.entity.Client;
import com.example.bvnk_client_service.facade.impl.DefaultTransactionFacade;
import com.example.bvnk_client_service.repository.ClientDAO;
import com.example.bvnk_client_service.service.TransactionService;
import com.example.bvnk_client_service.util.enumeration.TransactionStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DefaultTransactionFacadeTest {

	@InjectMocks
	private DefaultTransactionFacade testingInstance;

	@Mock
	private TransactionService transactionService;

	@Mock
	private TransactionDTO transactionDTO;

	@Mock
	private ClientDAO clientDAO;

	private final static Long clientId = 1L;

	@Test
	public void sendTransactionForCustomer_Success() {
		when(clientDAO.findById(clientId)).thenReturn(
				Optional.of(mock(Client.class)));

		when(transactionService.sendTransactionForCustomer(clientId, transactionDTO)).thenReturn(transactionDTO);
		TransactionDTO result = testingInstance.sendTransactionForCustomer(clientId, transactionDTO);
		assertThat(result).isEqualTo(transactionDTO);
	}

	@Test
	public void sendTransactionForCustomer_shouldThrowIllegalArgumentException() {
		IllegalArgumentException exception = assertThrows(
				IllegalArgumentException.class,
				() -> testingInstance.sendTransactionForCustomer(clientId, null)
		);
		assertThat(exception.getMessage()).isEqualTo("Invalid arguments");
	}

	@Test
	public void cancelTransactionForCustomer_Success() {
		when(transactionService.cancelTransactionForCustomer(clientId, transactionDTO)).thenReturn(transactionDTO);
		TransactionDTO result = testingInstance.cancelTransactionForCustomer(clientId, transactionDTO);
		assertThat(result).isEqualTo(transactionDTO);
	}

	@Test
	public void cancelTransactionForCustomer_shouldThrowIllegalArgumentException() {
		IllegalArgumentException exception = assertThrows(
				IllegalArgumentException.class,
				() -> testingInstance.cancelTransactionForCustomer(clientId, null)
		);
		assertThat(exception.getMessage()).isEqualTo("Invalid arguments");
	}

	@Test
	public void cancelTransactionForCustomer_shouldThrowIllegalStateException() {

		when(transactionDTO.getTransactionStatus()).thenReturn(TransactionStatus.CANCELLED);

		IllegalStateException exception = assertThrows(
				IllegalStateException.class,
				() -> testingInstance.cancelTransactionForCustomer(clientId, transactionDTO)
		);
		assertThat(exception.getMessage()).isEqualTo("Transaction already cancelled, status: CANCELLED");
	}

}
