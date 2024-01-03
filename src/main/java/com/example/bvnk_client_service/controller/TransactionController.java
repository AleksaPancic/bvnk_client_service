package com.example.bvnk_client_service.controller;

import com.example.bvnk_client_service.DTO.TransactionDTO;
import com.example.bvnk_client_service.facade.TransactionFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static com.example.bvnk_client_service.util.constants.ClientMicroserviceConstants.NOT_NULL_MESSAGE_FORMAT;


@RestController
@RequestMapping("/transaction")
public class TransactionController {

	private final TransactionFacade transactionFacade;

	@Autowired
	public TransactionController(final TransactionFacade transactionFacade) {
		this.transactionFacade = transactionFacade;
	}

	@PostMapping("/send")
	public TransactionDTO sendTransactionForCustomer(@RequestParam final Long clientId,
													 @RequestParam final TransactionDTO transactionDTO) {

		Objects.requireNonNull(String.format(NOT_NULL_MESSAGE_FORMAT, clientId));
		Objects.requireNonNull(String.format(NOT_NULL_MESSAGE_FORMAT, TransactionDTO.class.getSimpleName()));

		return transactionFacade.sendTransactionForCustomer(clientId, transactionDTO);
	}

	@DeleteMapping("/cancel")
	public TransactionDTO cancelTransactionForCustomer(@RequestParam final Long clientId,
													   @RequestParam final TransactionDTO transactionDTO) {

		Objects.requireNonNull(String.format(NOT_NULL_MESSAGE_FORMAT, clientId));
		Objects.requireNonNull(String.format(NOT_NULL_MESSAGE_FORMAT, TransactionDTO.class.getSimpleName()));

		return transactionFacade.cancelTransactionForCustomer(clientId, transactionDTO);
	}

}
