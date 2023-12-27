package com.example.bvnk_client_service.service;

import com.example.bvnk_client_service.DTO.response.HistoryDTO;


public interface HistoryService {
	HistoryDTO getHistoryForClient(Long clientId) throws IllegalStateException;
}
