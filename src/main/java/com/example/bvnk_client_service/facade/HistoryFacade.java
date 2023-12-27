package com.example.bvnk_client_service.facade;

import com.example.bvnk_client_service.DTO.response.HistoryDTO;


public interface HistoryFacade {
	HistoryDTO getHistoryForClient(Long clientId);
}
