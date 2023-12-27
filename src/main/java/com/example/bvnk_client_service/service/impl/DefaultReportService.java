package com.example.bvnk_client_service.service.impl;

import com.example.bvnk_client_service.DTO.ReportDTO;
import com.example.bvnk_client_service.api.ReportingServiceAPI;
import com.example.bvnk_client_service.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class DefaultReportService implements ReportService {
	private final ReportingServiceAPI reportingServiceAPI;

	private final static Logger LOG = LoggerFactory.getLogger(DefaultReportService.class);

	@Autowired
	public DefaultReportService(final ReportingServiceAPI reportingServiceAPI) {
		this.reportingServiceAPI = reportingServiceAPI;
	}

	@Override
	public ReportDTO updateReportForClient(final Long clientId, final ReportDTO report) throws IllegalStateException {

		final Map<String, Object> headers = createHeaders();

		final ResponseEntity<ReportDTO> response = reportingServiceAPI.createReportForCustomer(headers, clientId, report);
		if (response.getStatusCode() == HttpStatus.OK) {
			LOG.info("Updated report for client with id " + clientId);
			return response.getBody();
		} else {
			throw new IllegalStateException(String.format(
					"Error updating report for client: %d with status: %d",
					clientId, response.getStatusCode().value()));
		}
	}

	@Override
	public ReportDTO getReportForClient(final Long clientId) throws IllegalStateException {

		final Map<String, Object> headers = createHeaders();

		final ResponseEntity<ReportDTO> response = reportingServiceAPI.getReportForCustomer(headers, clientId);

		if (response.getStatusCode() == HttpStatus.OK) {
			LOG.info("Fetched report for client with id [%s]", clientId);
			return response.getBody();
		} else {
			throw new IllegalStateException(String.format(
					"Error fetching report for client: %d with status: %d",
					clientId, response.getStatusCode().value()));
		}
	}

	private Map<String, Object> createHeaders() {
		return Map.of("X_AUTHORIZATION", "null", "CONTENT_TYPE", "null");
	}

}
