package com.example.bvnk_client_service.service;

import com.example.bvnk_client_service.entity.Address;
import com.example.bvnk_client_service.entity.Client;


/**
 * This interface defines the methods that a service should provide to interact with the database and retrieve information about clients.
 *
 * @author BVNK
 *
 */
public interface ClientService {

    /**
     * Returns the client with the specified customer ID from the database
     *
     * @param customerId the customer ID of the client to retrieve
     * @return the client with the specified customer ID, or null if no client with that ID exists
     * @throws RuntimeException if there is an error retrieving the client from the database
     */
    Client getClientById(Long customerId) throws RuntimeException;

    /**
     * Updates the address for a specific client in the database
     *
     * @param clientId the ID of the client whose address is to be updated
     * @param address the updated address information for the client
     * @return the updated address information
     */
    Address updateAddressForClient(Long clientId, Address address);

}
