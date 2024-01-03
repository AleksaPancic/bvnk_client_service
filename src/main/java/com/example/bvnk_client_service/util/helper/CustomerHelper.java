package com.example.bvnk_client_service.util.helper;

/**
 * Interface for CustomerHelper class.
 */
public interface CustomerHelper {

	/**
	 * Checks if the customer ID is valid.
	 *
	 * @param clientId the customer ID
	 * @return true if the customer ID is valid, false otherwise
	 */
	Boolean isCustomerIdValid(Long clientId);

}
