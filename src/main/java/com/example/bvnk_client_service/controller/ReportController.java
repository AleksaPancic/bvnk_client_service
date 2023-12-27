package com.example.bvnk_client_service.controller;

import com.example.bvnk_client_service.DTO.response.ReportResponseData;
import com.example.bvnk_client_service.facade.ReportFacade;
import jakarta.annotation.Nonnull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/report")
public class ReportController {
	private final ReportFacade reportFacade;

	@Autowired
	public ReportController(final ReportFacade reportFacade) {
		this.reportFacade = reportFacade;
	}

	@GetMapping
	public ReportResponseData getReportForClient(@Nonnull @RequestParam final Long clientId) {
		return reportFacade.getReportForClient(clientId);
	}

	@PostMapping("/update")
	public ReportResponseData updateClientReport(@Nonnull @RequestParam final Long clientId,
												 @Nonnull @RequestBody final ReportResponseData report) {
		return reportFacade.updateClientReport(clientId, report);
	}

	//Create an empty client for report testing
	@GetMapping("/demome")
	public void demoCustomer() {
		reportFacade.makeADemoCustomerForTesting();
	}

}
