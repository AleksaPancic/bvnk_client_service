package com.example.bvnk_client_service.integration.controller;

import com.example.bvnk_client_service.DTO.ReportDTO;
import com.example.bvnk_client_service.controller.ReportController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static com.example.bvnk_client_service.util.constants.ClientMicroserviceConstants.CAN_NOT_UPDATE_REPORT;
import static com.example.bvnk_client_service.util.constants.ClientMicroserviceConstants.COULD_NOT_FIND_CLIENT_WITH_ID;
import static com.example.bvnk_client_service.util.constants.ClientMicroserviceConstants.NOT_NULL_MESSAGE_FORMAT;
import static com.example.bvnk_client_service.util.constants.ClientMicroserviceConstants.UPDATED_SUCCESSFUL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class ReportControllerIntegrationTest {

	private final ReportController reportController;

	private static final Long clientId = 1L;
	private static final Long clientIdMax = Long.MAX_VALUE;

	@Autowired
	public ReportControllerIntegrationTest(ReportController reportController) {
		this.reportController = reportController;
	}

	@Test
	public void getReportForClientSuccess() {
		ReportDTO report = reportController.getReportForClient(clientId).getBody();
		assertThat(report).isNotNull().isInstanceOf(ReportDTO.class);
	}

	@Test
	public void updateClientReportSuccess() {
		ReportDTO report = new ReportDTO();
		ResponseEntity<String> updatedReport = reportController.updateClientReport(clientId, report);
		assertThat(updatedReport.getBody()).isNotNull()
										   .contains(String.format(UPDATED_SUCCESSFUL, ReportDTO.class.getSimpleName()));
	}

	@Test
	public void getReportForClientFailure_shouldThrowNullPointerException() {
		NullPointerException exception = assertThrows(NullPointerException.class,
													  () -> reportController.getReportForClient(null));

		assertThat(exception.getMessage()).contains(String.format(NOT_NULL_MESSAGE_FORMAT, "clientId"));
	}

	@Test
	public void getReportForClientFailure_shouldIllegalArgumentException() {

		final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
																() -> reportController.getReportForClient(clientIdMax));

		assertThat(exception.getMessage()).contains(COULD_NOT_FIND_CLIENT_WITH_ID);
	}

	@Test
	public void updateClientReportFailure_shouldThrowNullPointerException() {

		NullPointerException exception = assertThrows(NullPointerException.class,
													  () -> reportController.updateClientReport(clientId, null));
		assertThat(exception.getMessage()).contains(String.format(NOT_NULL_MESSAGE_FORMAT, ReportDTO.class.getSimpleName()));
	}

	@Test
	public void updateClientReportFailure_shouldIllegalArgumentException() {

		ReportDTO report = new ReportDTO();
		final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
																() -> reportController.updateClientReport(clientIdMax, report));

		assertThat(exception.getMessage()).contains(CAN_NOT_UPDATE_REPORT);
	}
	//add IllegalStateException case also
}
