package com.example.bvnk_client_service.service;

import com.example.bvnk_client_service.DTO.ReportDTO;
import com.example.bvnk_client_service.entity.Client;
import com.example.bvnk_client_service.entity.Report;


public interface ClientService {
	/**
	 * Adds a new report to the database for the specified client
	 */
	void addReportToClient();

	/**
	 * Returns the client with the specified customer ID from the database
	 *
	 * @param customerId the customer ID of the client to retrieve
	 *
	 * @return the client with the specified customer ID, or null if no client with that ID exists
	 */
	Client getClientById(Long customerId);

	void addReportToClientById(Long id, ReportDTO report);
}
