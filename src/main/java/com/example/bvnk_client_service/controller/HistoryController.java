package com.example.bvnk_client_service.controller;

import com.example.bvnk_client_service.DTO.HistoryDTO;
import com.example.bvnk_client_service.facade.HistoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static com.example.bvnk_client_service.util.constants.ClientMicroserviceConstants.CLIENT_ID_NOT_NULL_MESSAGE_FORMAT;


@RestController
@RequestMapping("/history")
public class HistoryController {

	private final HistoryFacade historyFacade;

	@Autowired
	public HistoryController(final HistoryFacade historyFacade) {
		this.historyFacade = historyFacade;
	}

	@GetMapping
	public ResponseEntity<HistoryDTO> getHistoryForClient(@PathVariable final Long clientId) {

		Objects.requireNonNull(clientId, CLIENT_ID_NOT_NULL_MESSAGE_FORMAT);

		return ResponseEntity.ok(historyFacade.getHistoryForClient(clientId));
	}

}
