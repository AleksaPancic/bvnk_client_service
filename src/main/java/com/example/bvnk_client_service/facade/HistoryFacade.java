package com.example.bvnk_client_service.facade;

import com.example.bvnk_client_service.DTO.HistoryDTO;

import java.io.IOException;


/**
 * This interface provides methods for retrieving historical data for a specific client.
 */
public interface HistoryFacade {

    HistoryDTO getHistoryForClient(Long clientId) throws IllegalArgumentException, IOException;

}
