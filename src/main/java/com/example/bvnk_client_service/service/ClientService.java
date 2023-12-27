package com.example.bvnk_client_service.service;

import com.example.bvnk_client_service.DTO.response.ReportResponseData;
import com.example.bvnk_client_service.entity.Client;


public interface ClientService {

	/**
	 * Returns the client with the specified customer ID from the database
	 *
	 * @param customerId the customer ID of the client to retrieve
	 *
	 * @return the client with the specified customer ID, or null if no client with that ID exists
	 */
	Client getClientById(Long customerId);

}
