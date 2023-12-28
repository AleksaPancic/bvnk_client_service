package com.example.bvnk_client_service.unit.controller;

import com.example.bvnk_client_service.DTO.TransactionDTO;
import com.example.bvnk_client_service.controller.TransactionController;
import com.example.bvnk_client_service.facade.TransactionFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;


@ExtendWith(MockitoExtension.class)
public class TransactionControllerTest {

	@InjectMocks
	private TransactionController transactionController;

	@Mock
	private TransactionFacade transactionFacade;

	@Mock
	private TransactionDTO transactionDTO;

	private static final Long clientId = 1L;

	@Test
	public void sendTransactionForCustomer() {
        transactionController.sendTransactionForCustomer(clientId, transactionDTO);
        Mockito.verify(transactionFacade, times(1)).sendTransactionForCustomer(clientId, transactionDTO);
    }

	@Test
    public void cancelTransactionForCustomer() {
        transactionController.cancelTransactionForCustomer(clientId, transactionDTO);
        Mockito.verify(transactionFacade, times(1)).cancelTransactionForCustomer(clientId, transactionDTO);
    }

}
