package com.example.bvnk_client_service.facade;

import com.example.bvnk_client_service.DTO.HistoryDTO;


/**
 * This interface provides methods for retrieving historical data for a specific client.
 */
public interface HistoryFacade {

    /**
     * Retrieves the history data for a specific client.
     *
     * @param clientId the ID of the client for which to retrieve the history
     * @return a {@link HistoryDTO} object containing the client's historical data
     */
    HistoryDTO getHistoryForClient(Long clientId);

}
