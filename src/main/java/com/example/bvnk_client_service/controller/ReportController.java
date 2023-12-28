package com.example.bvnk_client_service.controller;

import com.example.bvnk_client_service.DTO.ReportDTO;
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
	public ReportDTO getReportForClient(@Nonnull @RequestParam final Long clientId) {
		return reportFacade.getReportForClient(clientId);
	}

	@PostMapping("/update")
	public ReportDTO updateClientReport(@Nonnull @RequestParam final Long clientId,
										@Nonnull @RequestBody final ReportDTO report) {
		return reportFacade.updateClientReport(clientId, report);
	}

}
