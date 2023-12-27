package com.example.bvnk_client_service.facade.impl;

import com.example.bvnk_client_service.DTO.TransactionDTO;
import com.example.bvnk_client_service.facade.TransactionFacade;
import com.example.bvnk_client_service.service.TransactionService;
import com.example.bvnk_client_service.util.constants.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;


@Facade
public class DefaultTransactionFacade implements TransactionFacade {

	private final TransactionService transactionService;

	@Autowired
    public DefaultTransactionFacade(final TransactionService transactionService) {
        this.transactionService = transactionService;
    }

	@Override
	public TransactionDTO sendTransactionForCustomer(final Long clientId, final TransactionDTO transactionDTO) {
		return transactionService.sendTransactionForCustomer(clientId, transactionDTO);
	}

	@Override
	public TransactionDTO cancelTransactionForCustomer(final Long clientId, final TransactionDTO transactionDTO)
			throws IllegalStateException {
		if (TransactionStatus.CANCELLED.equals(transactionDTO.getTransactionStatus())) {
			throw new IllegalStateException(
					"Transaction already cancelled, status: " + transactionDTO.getTransactionStatus().getDescription());
		}
		return transactionService.cancelTransactionForCustomer(clientId, transactionDTO);
	}

}
