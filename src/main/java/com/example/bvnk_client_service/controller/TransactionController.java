package com.example.bvnk_client_service.controller;

import com.example.bvnk_client_service.DTO.TransactionDTO;
import com.example.bvnk_client_service.facade.TransactionFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/transaction")
public class TransactionController {

	private final TransactionFacade transactionFacade;

	@Autowired
	public TransactionController(final TransactionFacade transactionFacade) {
		this.transactionFacade = transactionFacade;
	}

	@PostMapping("/send")
	public TransactionDTO sendTransactionForCustomer(@RequestParam Long clientId,
													 @RequestParam TransactionDTO transactionDTO) {
		return transactionFacade.sendTransactionForCustomer(clientId, transactionDTO);
	}

	@DeleteMapping("/cancel")
	public TransactionDTO cancelTransactionForCustomer(@RequestParam Long clientId,
														@RequestParam TransactionDTO transactionDTO) {
		return transactionFacade.cancelTransactionForCustomer(clientId, transactionDTO);
	}

}
