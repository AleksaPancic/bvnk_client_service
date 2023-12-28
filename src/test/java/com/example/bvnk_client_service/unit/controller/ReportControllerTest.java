package com.example.bvnk_client_service.unit.controller;

import com.example.bvnk_client_service.DTO.ReportDTO;
import com.example.bvnk_client_service.controller.ReportController;
import com.example.bvnk_client_service.facade.ReportFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;


@ExtendWith(MockitoExtension.class)
public class ReportControllerTest {

	@InjectMocks
	private ReportController reportController;

	@Mock
	private ReportFacade reportFacade;

	@Mock
	private ReportDTO reportDTO;

	private static final Long clientId = 1L;

	@Test
	public void getReportForClient() {
		reportController.getReportForClient(clientId);
		Mockito.verify(reportFacade, times(1)).getReportForClient(clientId);
	}

	@Test
	public void updateClientReport() {
		reportController.updateClientReport(clientId, reportDTO);
		Mockito.verify(reportFacade, times(1)).updateClientReport(clientId, reportDTO);
	}

}
