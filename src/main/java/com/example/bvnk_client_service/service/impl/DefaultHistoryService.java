package com.example.bvnk_client_service.service.impl;

import com.example.bvnk_client_service.DTO.HistoryDTO;
import com.example.bvnk_client_service.api.HistoryServiceAPI;
import com.example.bvnk_client_service.service.HistoryService;
import com.example.bvnk_client_service.util.function.CreateHeaderFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class DefaultHistoryService implements HistoryService {
	private final HistoryServiceAPI historyServiceAPI;
	private final CreateHeaderFunction createHeaderFunction;

	@Autowired
	public DefaultHistoryService(final HistoryServiceAPI historyServiceAPI, CreateHeaderFunction createHeaderFunction) {
		this.historyServiceAPI = historyServiceAPI;
		this.createHeaderFunction = createHeaderFunction;
	}

	@Override
	public HistoryDTO getHistoryForClient(final Long clientId) throws IllegalStateException {
		final Map<String, Object> headers = createHeaderFunction.createHeaders();
		final ResponseEntity<HistoryDTO> response = historyServiceAPI.getHistoryForCustomer(headers, clientId);
		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		} else {
			throw new IllegalStateException(String.format(
					"Error fetching history for client: %d with status: %d",
					clientId, response.getStatusCode().value()));
		}
	}

	@Override
	public HistoryDTO removeHistoryForClient(Long clientId) throws IllegalStateException {
		final Map<String, Object> headers = createHeaderFunction.createHeaders();
		final ResponseEntity<HistoryDTO> response = historyServiceAPI.removeHistoryForCustomer(headers, clientId);
		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		} else {
			throw new IllegalStateException(String.format(
					"Error removing history for client: %d with status: %d",
					clientId, response.getStatusCode().value()));
		}
	}

}
