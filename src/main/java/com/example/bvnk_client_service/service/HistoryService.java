package com.example.bvnk_client_service.service;

import com.example.bvnk_client_service.DTO.HistoryDTO;


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
    HistoryDTO getHistoryForClient(Long clientId) throws IllegalStateException;

}