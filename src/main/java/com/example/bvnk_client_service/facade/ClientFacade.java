package com.example.bvnk_client_service.facade;

import com.example.bvnk_client_service.entity.Address;
import com.example.bvnk_client_service.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ClientFacade {


	/**
	 * Creates a new instance of a demo customer for testing.
	 */
	void makeADemoCustomerForTesting();

	/**
	 * Updates the address for a client.
	 *
	 * @param clientId the ID of the client
	 * @param address the new address to update
	 *
	 * @return the updated address for the client
	 */
	Address updateAddressForClient(Long clientId, Address address);

	/**
	 * Retrieves all client pages based on the given Pageable object.
	 *
	 * @param pageable the Pageable object that specifies the page size, page number, and sorting criteria
	 *
	 * @return a Page object containing a list of Client objects
	 */
	Page<Client> getAllClientPages(Pageable pageable);

	/**
	 * Deletes a client with the specified client ID.
	 *
	 * @param  clientId   the ID of the client to be deleted
	 * @return            the Client containing the deleted client object
	 */
	Client deleteClient(Long clientId);

	/**
	 * Removes the address for the specified client.
	 *
	 * @param  clientId  the ID of the client
	 * @return           the address that was removed, or null if no address was found
	 */
	Address removeAddressForClient(Long clientId);

	/**
	 * Updates the first and last name of a client.
	 *
	 * @param  clientId    the ID of the client
	 * @param  firstName   the new first name
	 * @param  lastName    the new last name
	 * @return             the updated client object
	 */
	Client updateFirstAndLastName(Long clientId, String firstName, String lastName);

	/**
	 * Retrieves the number of clients in the database.
	 *
	 * @return the number of clients in the database
	 */
	Long getNumberOfClientsInDatabase();

	/**
	 * Retrieves the average number of years a client has been with the company.
	 *
	 * @return the average number of years a client has been with the company
	 */
	Double getAvgYearsClient();

}
