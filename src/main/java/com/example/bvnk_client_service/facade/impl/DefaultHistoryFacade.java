package com.example.bvnk_client_service.facade.impl;

import com.example.bvnk_client_service.DTO.HistoryDTO;
import com.example.bvnk_client_service.facade.HistoryFacade;
import com.example.bvnk_client_service.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;


@Facade
public class DefaultHistoryFacade implements HistoryFacade {

	private final HistoryService historyService;

	@Autowired
	public DefaultHistoryFacade(final HistoryService historyService) {
		this.historyService = historyService;
	}

	@Override
	public HistoryDTO getHistoryForClient(final Long clientId) {
		return historyService.getHistoryForClient(clientId);
	}

}
