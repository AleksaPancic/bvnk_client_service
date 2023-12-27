package com.example.bvnk_client_service.service.impl;

import com.example.bvnk_client_service.DTO.response.HistoryDTO;
import com.example.bvnk_client_service.api.HistoryServiceAPI;
import com.example.bvnk_client_service.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class DefaultHistoryService implements HistoryService {
	private final HistoryServiceAPI historyServiceAPI;

	@Autowired
	public DefaultHistoryService(final HistoryServiceAPI historyServiceAPI) {
		this.historyServiceAPI = historyServiceAPI;
	}

	@Override
	public HistoryDTO getHistoryForClient(final Long clientId) throws IllegalStateException {
		final Map<String, Object> headers = createHeaders();
		final ResponseEntity<HistoryDTO> response = historyServiceAPI.getHistoryForCustomer(headers, clientId);
		if(response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		} else {
			throw new IllegalStateException(String.format(
                    "Error fetching history for client: %d with status: %d",
                    clientId, response.getStatusCode().value()));
		}
	}

	private Map<String, Object> createHeaders() {
		return Map.of("X_AUTHORIZATION", "null", "CONTENT_TYPE", "null"); //TODO make it sepeare function
	}

}
