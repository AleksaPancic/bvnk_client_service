package com.example.bvnk_client_service.facade;

import com.example.bvnk_client_service.DTO.TransactionDTO;


/**
 * This interface defines the methods that a transaction facade should implement.
 * A transaction facade is a layer of abstraction between the business logic and the data access layer.
 * It is responsible for performing operations on transactions, such as sending and cancelling transactions,
 * and it isolates the business logic from the underlying data storage mechanism.
 */
public interface TransactionFacade {

    /**
     * This method is used to send a transaction for a customer.
     *
     * @param clientId    the ID of the customer
     * @param transaction the transaction details
     * @return the transaction details
     */
    TransactionDTO sendTransactionForCustomer(Long clientId, TransactionDTO transaction) throws IllegalArgumentException;

    /**
     * This method is used to cancel a transaction for a customer.
     *
     * @param clientId    the ID of the customer
     * @param transaction the transaction details
     * @return the transaction details
     * @throws IllegalStateException if the transaction cannot be cancelled
     */
    TransactionDTO cancelTransactionForCustomer(Long clientId, TransactionDTO transaction)
            throws IllegalStateException, IllegalArgumentException;

}
