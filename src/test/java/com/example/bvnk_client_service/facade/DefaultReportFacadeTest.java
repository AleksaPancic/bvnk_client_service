package com.example.bvnk_client_service.facade;

import com.example.bvnk_client_service.DTO.ReportDTO;
import com.example.bvnk_client_service.entity.Client;
import com.example.bvnk_client_service.facade.impl.DefaultReportFacade;
import com.example.bvnk_client_service.repository.ClientDAO;
import com.example.bvnk_client_service.service.ClientService;
import com.example.bvnk_client_service.service.ReportService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DefaultReportFacadeTest {
	@InjectMocks
	DefaultReportFacade testingInstance;

	@Mock
	ReportService reportService;
	@Mock
	ClientService clientService;
	@Mock
	ClientDAO clientDAO;
	@Mock
	ReportDTO reportDTO;
	@Mock
	ReportDTO reportDTO2;

	private static final Long clientId = 1L;

	@Test
	public void updateClientReport_Success() {
		when(reportService.updateReportForClient(clientId, reportDTO)).thenReturn(reportDTO2);

		ReportDTO result = testingInstance.updateClientReport(clientId, reportDTO);

		assertThat(result).isEqualTo(reportDTO2);
	}

	@Test
	public void updateClientReport_shouldThrowIllegalArgumentException() {

		IllegalArgumentException exception = assertThrows(
				IllegalArgumentException.class,
				() -> testingInstance.updateClientReport(clientId, null)
		);
		assertThat(exception.getMessage()).isEqualTo("Invalid report");
	}

	@Test
    public void getReportForClient_Success() {

		when(clientDAO.findById(clientId)).thenReturn(
				Optional.of(mock(Client.class)));

		when(reportService.getReportForClient(clientId)).thenReturn(reportDTO);

		ReportDTO result = testingInstance.getReportForClient(clientId);

		assertThat(result).isEqualTo(reportDTO);
	}

	@Test
    public void getReportForClient_shouldThrowIllegalArgumentException() {

		IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () ->testingInstance.getReportForClient(null)
        );

		assertThat(exception.getMessage()).isEqualTo("Client id should not be null");
	}

}
