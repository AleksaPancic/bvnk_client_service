package com.example.bvnk_client_service.service;

import com.example.bvnk_client_service.DTO.response.ReportResponseData;

import java.util.List;


public interface ReportService {

	/**
	 * Returns a list of all reports in the system
	 *
	 * @return a list of all reports in the system
	 */
	List<ReportResponseData> getReports();

	ReportResponseData getReportForClient(Long clientId, Long reportId);
}
