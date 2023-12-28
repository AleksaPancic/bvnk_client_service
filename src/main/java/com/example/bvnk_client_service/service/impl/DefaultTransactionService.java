package com.example.bvnk_client_service.service.impl;

import com.example.bvnk_client_service.DTO.TransactionDTO;
import com.example.bvnk_client_service.api.TransactionServiceAPI;
import com.example.bvnk_client_service.service.TransactionService;
import com.example.bvnk_client_service.util.function.CreateHeaderFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class DefaultTransactionService implements TransactionService {

	private final TransactionServiceAPI transactionServiceAPI;
	private final CreateHeaderFunction createHeaderFunction;

	@Autowired
	public DefaultTransactionService(final TransactionServiceAPI transactionServiceAPI, CreateHeaderFunction createHeaderFunction) {
		this.transactionServiceAPI = transactionServiceAPI;
		this.createHeaderFunction = createHeaderFunction;
	}

	@Override
	public TransactionDTO sendTransactionForCustomer(final Long clientId, final TransactionDTO transactionDTO) {
		final Map<String, Object> headers = createHeaderFunction.createHeaders();
		final ResponseEntity<TransactionDTO> response = transactionServiceAPI.addTransactionForClient(headers, clientId,
																									  transactionDTO);
		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		} else {
			throw new IllegalStateException(String.format(
					"Error sending transaction for client: %d with status: %d",
					clientId, response.getStatusCode().value()));
		}
	}

	@Override
	public TransactionDTO cancelTransactionForCustomer(final Long clientId, final TransactionDTO transactionDTO) {
		final Map<String, Object> headers = createHeaderFunction.createHeaders();
		final ResponseEntity<TransactionDTO> response = transactionServiceAPI.cancelTransactionForClient(headers, clientId,
																										 transactionDTO);
		if(response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		} else {
			throw new IllegalStateException(String.format(
                    "Error cancelling transaction for client: %d with status: %d",
                    clientId, response.getStatusCode().value()));
		}
	}

}
