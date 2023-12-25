package com.example.bvnk_client_service.service.impl;

import com.example.bvnk_client_service.DTO.response.ReportResponseData;
import com.example.bvnk_client_service.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;


@Service
public class DefaultReportService implements ReportService {

	@Value("${reportTemplate}")
	private String REPORT_SERVICE_URL;
	private RestTemplate reportTemplate;

	private final static Logger LOG = LoggerFactory.getLogger(DefaultReportService.class);

	@Autowired
	public DefaultReportService(final RestTemplate reportTemplate) {
		this.reportTemplate = reportTemplate;
	}

	@Override
	public List<ReportResponseData> getReports() {
		// Make a GET request to the Report microservice
		ResponseEntity<List<ReportResponseData>> response = reportTemplate.exchange(
				REPORT_SERVICE_URL,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<ReportResponseData>>() {
				}
		);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		} else {
			// Handle error scenarios
			return Collections.emptyList();
		}
	}
	@Override
	public ReportResponseData getReportForClient(Long clientId, Long reportId) {
		// Set up query parameters
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(REPORT_SERVICE_URL)
														   .queryParam("clientId", clientId)
														   .queryParam("reportId", reportId);

		// Make a GET request to the Report microservice
		ResponseEntity<ReportResponseData> response = reportTemplate.exchange(
				builder.toUriString(),
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<ReportResponseData>() {
				}
		);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		} else {
			// Handle error scenarios
			LOG.error("Error getting report for client: " + clientId + " and report: " + reportId);
			return null;
		}
	}

}
