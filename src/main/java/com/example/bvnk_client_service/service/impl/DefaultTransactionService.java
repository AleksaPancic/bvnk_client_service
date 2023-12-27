package com.example.bvnk_client_service.service.impl;

import com.example.bvnk_client_service.DTO.TransactionDTO;
import com.example.bvnk_client_service.api.TransactionServiceAPI;
import com.example.bvnk_client_service.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class DefaultTransactionService implements TransactionService {

	private final TransactionServiceAPI reportingServiceAPI;

	@Autowired
	public DefaultTransactionService(final TransactionServiceAPI reportingServiceAPI) {
		this.reportingServiceAPI = reportingServiceAPI;
	}

	@Override
	public TransactionDTO sendTransactionForCustomer(Long clientId, TransactionDTO transactionDTO) {
		Map<String, Object> headers = createHeaders();
		ResponseEntity<TransactionDTO> response = reportingServiceAPI.addTransactionForClient(headers, clientId,
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
	public TransactionDTO cancelTransactionForCustomer(Long clientId, TransactionDTO transactionDTO) {
		Map<String, Object> headers = createHeaders();
		ResponseEntity<TransactionDTO> response = reportingServiceAPI.cancelTransactionForClient(headers, clientId,
																								 transactionDTO);
		if(response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		} else {
			throw new IllegalStateException(String.format(
                    "Error cancelling transaction for client: %d with status: %d",
                    clientId, response.getStatusCode().value()));
		}
	}

	private Map<String, Object> createHeaders() {
		return Map.of("X_AUTHORIZATION", "null", "CONTENT_TYPE", "null");
	}

}
