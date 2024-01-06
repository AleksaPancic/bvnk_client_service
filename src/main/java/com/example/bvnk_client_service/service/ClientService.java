package com.example.bvnk_client_service.service;

import com.example.bvnk_client_service.entity.Address;
import com.example.bvnk_client_service.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * This interface defines the methods that a service should provide to interact with the database and retrieve information
 * about clients.
 *
 * @author Aleksa Pancic
 */
public interface ClientService {

	/**
	 * Returns the client with the specified customer ID from the database
	 *
	 * @param customerId the customer ID of the client to retrieve
	 *
	 * @return the client with the specified customer ID, or null if no client with that ID exists
	 *
	 * @throws RuntimeException if there is an error retrieving the client from the database
	 */
	Client getClientById(Long customerId) throws RuntimeException;

	/**
	 * Updates the address for a specific client in the database
	 *
	 * @param clientId the ID of the client whose address is to be updated
	 * @param address the updated address information for the client
	 *
	 * @return the updated address information
	 */
	Address updateAddressForClient(Long clientId, Address address);

	/**
	 * Retrieves all the pages of clients based on the given pageable object.
	 *
	 * @param pageable the pageable object that specifies the pagination parameters
	 *
	 * @return the page of clients based on the given pageable object
	 */
	Page<Client> getAllClientPages(Pageable pageable);

	/**
	 * Deletes a client with the given client ID.
	 *
	 * @param clientId the ID of the client to be deleted
	 *
	 * @return the response entity containing the deleted client
	 */
	Client deleteClient(Long clientId);

	/**
	 * Removes the address for the specified client.
	 *
	 * @param clientId the ID of the client
	 *
	 * @return the removed address
	 */
	Address removeAddressForClient(Long clientId);

	/**
	 * Updates the first and last name of a client.
	 *
	 * @param clientId the ID of the client
	 * @param firstName the new first name for the client
	 * @param lastName the new last name for the client
	 *
	 * @return the updated client object
	 */
	Client updateFirstAndLastName(Long clientId, String firstName, String lastName);

	/**
	 * Retrieves the number of clients in the database.
	 *
	 * @return the number of clients in the database
	 */
	Long getNumberOfClientsInDatabase();

	/**
	 * Returns the average number of years a client has been with the company.
	 *
	 * @return the average number of years a client has been with the company
	 */
	Double getAvgYearsClient();

}
