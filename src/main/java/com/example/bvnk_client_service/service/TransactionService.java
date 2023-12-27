package com.example.bvnk_client_service.service;

import com.example.bvnk_client_service.DTO.TransactionDTO;


/**
 * This interface defines the methods that a transaction service should provide.
 * The service is responsible for sending and cancelling transactions for customers.
 */
public interface TransactionService {

    /**
     * This method sends a transaction for a customer.
     *
     * @param clientId    the ID of the customer
     * @param transaction the transaction details
     * @return the transaction details
     */
    TransactionDTO sendTransactionForCustomer(Long clientId, TransactionDTO transaction);

    /**
     * This method cancels a transaction for a customer.
     *
     * @param clientId    the ID of the customer
     * @param transaction the transaction details
     * @return the transaction details
     */
    TransactionDTO cancelTransactionForCustomer(Long clientId, TransactionDTO transaction);

}
