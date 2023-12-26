package com.example.bvnk_client_service.controller;

import com.example.bvnk_client_service.DTO.response.ReportResponseData;
import com.example.bvnk_client_service.facade.ReportFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/report")
public class ReportController {
	private ReportFacade reportFacade;

	@Autowired
	public ReportController(final ReportFacade reportFacade) {
		this.reportFacade = reportFacade;
	}

	@GetMapping
	public ReportResponseData getReportForClient(@RequestParam Long clientId) {
		return reportFacade.getReportForClient(clientId);
	}

	@PostMapping("/update")
	public void updateClientReport(@RequestParam Long clientId,
								   @RequestParam Long reportId) {
		reportFacade.updateClientReport(clientId, reportId);
	}

	//Create an empty client for testing
	@GetMapping("/demome")
	public void demoCustomer() {
		reportFacade.makeADemoCustomerForTesting();
	}

}
