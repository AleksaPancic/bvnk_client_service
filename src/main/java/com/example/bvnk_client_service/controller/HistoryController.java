package com.example.bvnk_client_service.controller;

import com.example.bvnk_client_service.DTO.response.HistoryDTO;
import com.example.bvnk_client_service.facade.HistoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/history")
public class HistoryController {

	private final HistoryFacade historyFacade;

	@Autowired
	public HistoryController(HistoryFacade historyFacade) {
		this.historyFacade = historyFacade;
	}

	public HistoryDTO getHistoryForClient(@RequestParam Long clientId) {
		return historyFacade.getHistoryForClient(clientId);
	}
}
