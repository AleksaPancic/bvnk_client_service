package com.example.bvnk_client_service.unit.facade;

import com.example.bvnk_client_service.DTO.ReportDTO;
import com.example.bvnk_client_service.entity.Client;
import com.example.bvnk_client_service.facade.impl.DefaultReportFacade;
import com.example.bvnk_client_service.repository.ClientDAO;
import com.example.bvnk_client_service.service.ClientService;
import com.example.bvnk_client_service.service.ReportService;
import com.example.bvnk_client_service.util.helper.CustomerHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DefaultReportFacadeTest {
	@InjectMocks
	DefaultReportFacade testingInstance;

	@Mock
	private ReportService reportService;
	@Mock
	private ClientService clientService;
	@Mock
	private ClientDAO clientDAO;
	@Mock
	private ReportDTO reportDTO;
	@Mock
	private ReportDTO reportDTO2;
	@Mock
	private CustomerHelper customerHelper;

	private static final Long clientId = 1L;

	@BeforeEach
	public void setUp() {
		lenient().when(customerHelper.isCustomerIdValid(clientId)).thenReturn(true);
	}

	@Test
	public void updateClientReport_Success() {
		when(reportService.updateReportForClient(clientId, reportDTO)).thenReturn(reportDTO2);

		ReportDTO result = testingInstance.updateClientReport(clientId, reportDTO);

		assertThat(result).isEqualTo(reportDTO2);
	}

	@Test
	public void getReportForClient_Success() {
		lenient().when(clientDAO.findById(clientId)).thenReturn(
				Optional.of(mock(Client.class)));

		lenient().when(reportService.getReportForClient(clientId)).thenReturn(reportDTO);
		ReportDTO result = testingInstance.getReportForClient(clientId);

		assertThat(result).isEqualTo(reportDTO);
	}

	@Test
	public void getReportForClient_shouldThrowNullPointerException() {

		IllegalArgumentException exception = assertThrows(
				IllegalArgumentException.class,
				() -> testingInstance.getReportForClient(null)
		);

		assertThat(exception.getMessage()).contains("Could not find client with id");
	}

}
