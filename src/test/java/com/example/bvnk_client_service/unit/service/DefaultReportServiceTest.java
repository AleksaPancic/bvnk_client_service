package com.example.bvnk_client_service.unit.service;

import com.example.bvnk_client_service.DTO.ReportDTO;
import com.example.bvnk_client_service.api.ReportingServiceAPI;
import com.example.bvnk_client_service.service.impl.DefaultReportService;
import com.example.bvnk_client_service.util.function.CreateHeaderFunction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.junit.Before; TODO add dependency


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DefaultReportServiceTest {

	@InjectMocks
	private DefaultReportService defaultReportService;

	@Mock
	private ReportingServiceAPI reportingServiceAPI;

	@Mock
	private CreateHeaderFunction createHeaderFunction;

	@Mock
	private ResponseEntity<ReportDTO> response;

	private static final Long clientId = 1L;

	@Test
	public void getReportForClient_WhenResponseSuccess() {
		when(reportingServiceAPI.getReportForCustomer(any(), any())).thenReturn(response);
		when(response.getStatusCode()).thenReturn(HttpStatus.OK);
		when(response.getBody()).thenReturn(new ReportDTO());

		ReportDTO result = defaultReportService.getReportForClient(clientId);

		assertThat(result).isNotNull();
	}

	@Test
	public void shouldThrowException_WhenResponseIsNotSuccessful() {
		ResponseEntity<ReportDTO> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		when(reportingServiceAPI.getReportForCustomer(any(), any())).thenReturn(response);

		IllegalStateException exception = org.junit.jupiter.api.Assertions.assertThrows(
				IllegalStateException.class,
				() -> defaultReportService.getReportForClient(clientId)
		);
		assertThat(exception.getMessage()).contains("Error fetching report for client:");
	}

}
