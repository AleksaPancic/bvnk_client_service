package com.example.bvnk_client_service.service.impl;

import com.example.bvnk_client_service.DTO.ReportDTO;
import com.example.bvnk_client_service.api.ReportingServiceAPI;
import com.example.bvnk_client_service.service.ReportService;
import com.example.bvnk_client_service.util.function.CreateHeaderFunction;
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
	private final CreateHeaderFunction createHeaderFunction;

	private static final Logger LOG = LoggerFactory.getLogger(DefaultReportService.class);

	@Autowired
	public DefaultReportService(final ReportingServiceAPI reportingServiceAPI, final CreateHeaderFunction createHeaderFunction) {
		this.reportingServiceAPI = reportingServiceAPI;
		this.createHeaderFunction = createHeaderFunction;
	}

	@Override
	public ReportDTO updateReportForClient(final Long clientId, final ReportDTO report) throws IllegalStateException {

		final Map<String, Object> headers = createHeaderFunction.createHeaders();
		final ResponseEntity<ReportDTO> response = reportingServiceAPI.createReportForCustomer(headers, clientId, report);
		if (response.getStatusCode() == HttpStatus.OK) {
			LOG.info(String.format("Updated report for client with id %d", clientId));
			return response.getBody();
		} else {
			throw new IllegalStateException(String.format(
					"Error updating report for client: %d with status: %d",
					clientId, response.getStatusCode().value()));
		}
	}

	@Override
	public ReportDTO getReportForClient(final Long clientId) throws IllegalStateException {

		final Map<String, Object> headers = createHeaderFunction.createHeaders();

		final ResponseEntity<ReportDTO> response = reportingServiceAPI.getReportForCustomer(headers, clientId);

		if (response.getStatusCode() == HttpStatus.OK) {
			LOG.info(String.format("Found report for client: %d", clientId));
			return response.getBody();
		} else {
			throw new IllegalStateException(String.format(
					"Error fetching report for client: %d with status: %d",
					clientId, response.getStatusCode().value()));
		}
	}

	@Override
	public ReportDTO removeReportForClient(Long clientId) throws IllegalStateException {

		final Map<String, Object> headers = createHeaderFunction.createHeaders();

		final ResponseEntity<ReportDTO> response = reportingServiceAPI.removeReportForCustomer(headers, clientId);

		if (response.getStatusCode() == HttpStatus.OK) {
			LOG.info("Removed report for client with id %d", clientId);
			return response.getBody();
		} else {
			throw new IllegalStateException(String.format(
					"Error fetching report for client: %d with status: %d",
					clientId, response.getStatusCode().value()));
		}
	}

}
