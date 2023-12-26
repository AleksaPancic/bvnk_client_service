package com.example.bvnk_client_service.facade;

import com.example.bvnk_client_service.DTO.response.ReportResponseData;


public interface ReportFacade {
	void updateClientReport(Long clientId, Long reportId);

	void makeADemoCustomerForTesting();

	ReportResponseData getReportForClient(Long clientId);
}
