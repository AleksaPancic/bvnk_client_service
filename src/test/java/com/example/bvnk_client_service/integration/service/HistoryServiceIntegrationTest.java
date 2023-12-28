package com.example.bvnk_client_service.integration.service;

import com.example.bvnk_client_service.DTO.HistoryDTO;
import com.example.bvnk_client_service.service.HistoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class HistoryServiceIntegrationTest {
	private final HistoryService historyService;

	private static final Long clientId = 1L;

	@Autowired
	public HistoryServiceIntegrationTest(final HistoryService historyService) {
		this.historyService = historyService;
	}

	@Test
	public void getHistoryForClient_Success() throws IllegalStateException {
		final HistoryDTO historyDTO = historyService.getHistoryForClient(clientId);
		//TODO
	}
}
