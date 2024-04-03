package com.example.bvnk_client_service.service;

import com.example.bvnk_client_service.DTO.HistoryDTO;

import java.io.IOException;


/**
 * This interface defines the methods that a history service should implement.
 * A history service is responsible for retrieving historical data for a specific client.
 */
public interface HistoryService {

    /**
     * Retrieves the history data for a specific client.
     *
     * @param clientId the ID of the client for which to retrieve the history
     * @return a {@link HistoryDTO} object containing the client's historical data
     * @throws IllegalStateException if the history cannot be retrieved
     */
    HistoryDTO getHistoryForClient(Long clientId) throws IllegalStateException, IOException;

	/**
	 * Removes the history for a client.
	 *
	 * @param  clientId  the ID of the client
	 * @return           the DTO object representing the removed history
	 * @throws IllegalStateException  if the operation is not allowed
	 */
	HistoryDTO removeHistoryForClient(Long clientId) throws IllegalStateException;

}