package com.example.bvnk_client_service.integration.controller;

import com.example.bvnk_client_service.DTO.ReportDTO;
import com.example.bvnk_client_service.controller.ReportController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class ReportControllerIntegrationTest {

	private final ReportController reportController;

	private static final Long clientId = 1L;

	@Autowired
	public ReportControllerIntegrationTest(ReportController reportController) {
		this.reportController = reportController;
	}

	@Test
	public void getReportForClientSuccess() {
		ReportDTO report = reportController.getReportForClient(clientId);
		assertThat(report).isNotNull();
		assertThat(report).isInstanceOf(ReportDTO.class);
	}

	@Test
	public void getReportForClientFailure() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
														  () -> reportController.getReportForClient(null));

		assertThat(exception.getMessage()).contains("Client id should not");
    }

	@Test
	public void updateClientReportSuccess() {
		ReportDTO report = new ReportDTO();
        ResponseEntity<String> updatedReport = reportController.updateClientReport(clientId, report);
        assertThat(updatedReport.getBody()).isNotNull();
        assertThat(updatedReport.getBody()).isInstanceOf(ReportDTO.class);
	}

	@Test
	public void updateClientReportFailure() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
														  () -> reportController.updateClientReport(clientId, null));
		assertThat(exception.getMessage()).contains("Invalid report");
	}

}
