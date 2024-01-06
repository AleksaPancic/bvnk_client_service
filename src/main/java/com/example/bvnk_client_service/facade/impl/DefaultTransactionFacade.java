package com.example.bvnk_client_service.facade.impl;

import com.example.bvnk_client_service.DTO.TransactionDTO;
import com.example.bvnk_client_service.facade.TransactionFacade;
import com.example.bvnk_client_service.repository.ClientDAO;
import com.example.bvnk_client_service.service.TransactionService;
import com.example.bvnk_client_service.util.enumeration.TransactionStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


@Facade
public class DefaultTransactionFacade implements TransactionFacade {

	private final TransactionService transactionService;
	private final ClientDAO clientDAO;

	private static final Logger LOG = LoggerFactory.getLogger(DefaultTransactionFacade.class);

	@Autowired
	public DefaultTransactionFacade(final TransactionService transactionService, ClientDAO clientDAO) {
		this.transactionService = transactionService;
		this.clientDAO = clientDAO;
	}

	@Override
	public TransactionDTO sendTransactionForCustomer(final Long clientId, final TransactionDTO transactionDTO)
			throws IllegalArgumentException {
		if (clientId == null || transactionDTO == null || !clientDAO.findById(clientId).isPresent()) {
			throw new IllegalArgumentException("Could not send transaction for client " + clientId);
		}
		return transactionService.sendTransactionForCustomer(clientId, transactionDTO);
	}

	@Override
	public TransactionDTO cancelTransactionForCustomer(final Long clientId, final TransactionDTO transactionDTO)
			throws IllegalStateException, IllegalArgumentException {

		if (clientId == null || transactionDTO == null) {
			throw new IllegalArgumentException("Invalid client id provided for transaction " + clientId);
		} else if (TransactionStatus.CANCELLED.equals(transactionDTO.getTransactionStatus())) {
			throw new IllegalStateException(
					"Transaction already cancelled, status: " + transactionDTO.getTransactionStatus().getDescription());
		}

		LOG.info(String.format("Sending transaction for client %d", clientId));
		return transactionService.cancelTransactionForCustomer(clientId, transactionDTO);
	}

}
