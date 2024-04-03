package com.example.bvnk_client_service.service.impl;

import com.example.bvnk_client_service.DTO.HistoryDTO;
import com.example.bvnk_client_service.api.HistoryServiceAPI;
import com.example.bvnk_client_service.service.HistoryService;
import com.example.bvnk_client_service.util.function.CreateHeaderFunction;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;


@Service
public class DefaultHistoryService implements HistoryService {
	@Value("${is.mock.data.history.api.enabled}")
	private boolean isMockEnabled;
	private final HistoryServiceAPI historyServiceAPI;
	private final CreateHeaderFunction createHeaderFunction;

	@Autowired
	public DefaultHistoryService(final HistoryServiceAPI historyServiceAPI, CreateHeaderFunction createHeaderFunction) {
		this.historyServiceAPI = historyServiceAPI;
		this.createHeaderFunction = createHeaderFunction;
	}

	@Override
	public HistoryDTO getHistoryForClient(final Long clientId) throws IllegalStateException, IOException {
		if (isMockEnabled) {
			final ObjectMapper objectMapper = new ObjectMapper();
			final ClassPathResource jsonFile = new ClassPathResource("mockdata/historyAPI_response.json");
			final HistoryDTO historyDTO = objectMapper.readValue(jsonFile.getInputStream(), HistoryDTO.class);
			return historyDTO;
		}
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
