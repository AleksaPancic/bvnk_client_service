package com.example.bvnk_client_service.controller;

import com.example.bvnk_client_service.DTO.HistoryDTO;
import com.example.bvnk_client_service.facade.HistoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/history")
public class HistoryController {

	private final HistoryFacade historyFacade;

	@Autowired
	public HistoryController(final HistoryFacade historyFacade) {
		this.historyFacade = historyFacade;
	}

	@GetMapping
	public HistoryDTO getHistoryForClient(@RequestParam final Long clientId) {
		return historyFacade.getHistoryForClient(clientId);
	}

}
