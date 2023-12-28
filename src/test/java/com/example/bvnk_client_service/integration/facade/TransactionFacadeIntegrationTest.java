package com.example.bvnk_client_service.integration.facade;

import com.example.bvnk_client_service.DTO.TransactionDTO;
import com.example.bvnk_client_service.facade.TransactionFacade;
import com.example.bvnk_client_service.util.enumeration.TransactionStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;


@SpringBootTest
public class TransactionFacadeIntegrationTest {
	private final TransactionFacade transactionFacade;

	private static final Long clientId = 1L;

	private TransactionDTO transactionDTO;

	@BeforeEach
	public void setUp() {
		transactionDTO = new TransactionDTO();
	}

	@Autowired
	public TransactionFacadeIntegrationTest(final TransactionFacade transactionFacade) {
		this.transactionFacade = transactionFacade;
	}

	@Test
	public void sendTransactionForCustomer_Success() throws IllegalArgumentException {
		final TransactionDTO transaction = transactionFacade.sendTransactionForCustomer(clientId, transactionDTO);
		assertThat(transaction).isNotNull();
		assertThat(transaction).isInstanceOf(TransactionDTO.class);
		assertThat(transaction.getClientId()).isEqualTo(clientId);
	}

	@Test
	public void cancelTransactionForCustomer_Success() throws IllegalStateException {
		final TransactionDTO transaction = transactionFacade.cancelTransactionForCustomer(clientId, transactionDTO);
		assertThat(transaction).isNotNull();
		assertThat(transaction).isInstanceOf(TransactionDTO.class);
		assertThat(transaction.getClientId()).isEqualTo(clientId);
	}

	@Test
	public void sendTransactionForCustomer_Failure_ShouldThrowIllegalArgumentException() throws IllegalArgumentException {
		final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
																() -> transactionFacade.sendTransactionForCustomer(null,
																												   transactionDTO));
		assertThat(exception.getMessage()).contains("Could not send transaction for client");
	}

	@Test
	public void cancelTransactionForCustomer_Failure_ShouldThrowIllegalArgumentException()
			throws IllegalArgumentException, IllegalStateException {
		final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
																() -> transactionFacade.cancelTransactionForCustomer(null,
																													 transactionDTO));
		assertThat(exception.getMessage()).contains("Invalid client id provided for transaction");
	}

	@Test
	public void cancelTransactionForCustomer_Failure_ShouldThrowIllegalStateException()
			throws IllegalArgumentException {
		transactionDTO.setTransactionStatus(TransactionStatus.CANCELLED);

		assertThrows(IllegalStateException.class, () -> {
			transactionFacade.cancelTransactionForCustomer(clientId, transactionDTO);
		});
	}

}
