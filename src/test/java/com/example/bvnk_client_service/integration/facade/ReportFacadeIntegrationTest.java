package com.example.bvnk_client_service.integration.facade;

import com.example.bvnk_client_service.DTO.ReportDTO;
import com.example.bvnk_client_service.facade.ReportFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class ReportFacadeIntegrationTest {

	private final ReportFacade reportFacade;

	private ReportDTO reportDTO;

	private static final Long clientId = 1L;

	@BeforeEach
	public void setUp() {
		reportDTO = new ReportDTO();
    }

	@Autowired
	public ReportFacadeIntegrationTest(final ReportFacade reportFacade) {
		this.reportFacade = reportFacade;
	}

	@Test
	public void updateClientReport_Success() throws IllegalArgumentException {
        final ReportDTO report = reportFacade.updateClientReport(clientId, reportDTO);
		assertThat(report).isNotNull();
		assertThat(report).isInstanceOf(ReportDTO.class);
		assertThat(report.getClientId()).isEqualTo(clientId);
	}

	@Test
	public void updateClientReport_Failure_ShouldThrowIllegalArgumentException() throws IllegalArgumentException {
		final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
																() -> reportFacade.updateClientReport(null, reportDTO));

		assertThat(exception.getMessage()).contains("Invalid report for client with id");
		assertThat(exception).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
    public void getReportForClient_Success() {
		final ReportDTO report = reportFacade.getReportForClient(clientId);
		assertThat(report).isNotNull();
		assertThat(report).isInstanceOf(ReportDTO.class);
		assertThat(report.getClientId()).isEqualTo(clientId);
	}

	@Test
	public void getReportForClient_Failure_ShouldThrowIllegalArgumentException() {
		final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                                                                () -> reportFacade.getReportForClient(null));

        assertThat(exception.getMessage()).contains("Could not find client with id");
        assertThat(exception).isInstanceOf(IllegalArgumentException.class);
	}

}
