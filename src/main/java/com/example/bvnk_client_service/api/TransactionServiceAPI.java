package com.example.bvnk_client_service.api;

import com.example.bvnk_client_service.DTO.TransactionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;



/**
 * This interface defines the methods that the client can use to interact with the transaction microservice.
 */
@FeignClient(name = "transactionMicroservice", url = "${transactionMicroservice.url}")
public interface TransactionServiceAPI {

	/**
	 * Adds a new transaction for the specified client.
	 *
	 * @param headers the headers of the request
	 * @param clientId the ID of the client
	 * @param transaction the transaction details
	 *
	 * @return the newly created transaction
	 */
	@PostMapping
	ResponseEntity<TransactionDTO> addTransactionForClient(
			@RequestHeader Map<String, Object> headers,
			@RequestParam Long clientId,
			@RequestBody TransactionDTO transaction);

	/**
	 * Retrieves a transaction for a client.
	 *
	 * @param headers a map of request headers
	 * @param clientId the ID of the client
	 *
	 * @return the transaction DTO
	 */
	@GetMapping
	ResponseEntity<TransactionDTO> getTransactionForClient(
			@RequestHeader Map<String, Object> headers,
			@RequestParam Long clientId
	);

	/**
	 * Cancels an existing transaction for the specified client.
	 *
	 * @param headers the headers of the request
	 * @param clientId the ID of the client
	 * @param transaction the transaction details
	 *
	 * @return the cancelled transaction
	 */
	@DeleteMapping
	ResponseEntity<TransactionDTO> cancelTransactionForClient(
			@RequestHeader Map<String, Object> headers,
			@RequestParam Long clientId,
			@RequestBody TransactionDTO transaction);

	//different cancellation reasons, transaction communicating with bank accepted, denied etc
}
