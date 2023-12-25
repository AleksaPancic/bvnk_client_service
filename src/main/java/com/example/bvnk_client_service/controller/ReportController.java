package com.example.bvnk_client_service.controller;

import com.example.bvnk_client_service.DTO.response.ReportResponseData;
import com.example.bvnk_client_service.entity.Client;
import com.example.bvnk_client_service.repository.ClientRepository;
import com.example.bvnk_client_service.service.ClientService;
import com.example.bvnk_client_service.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/report")
public class ReportController {

	private ReportService reportService;
	private ClientService clientService;
	private ClientRepository clientRepository;
	private final static Logger LOG = LoggerFactory.getLogger(ReportController.class);

	@Autowired
    public ReportController(ReportService reportService, ClientService clientService, ClientRepository clientRepository) {
        this.reportService = reportService;
		this.clientService = clientService;
		this.clientRepository = clientRepository;
	}

	@PostMapping
	public void updateCustomerReports() {
		List<ReportResponseData> reports = reportService.getReports();
		Optional<ReportResponseData> test = reports.stream().findFirst();
		clientService.addReportToClient();
		if (test.isPresent()) {
			LOG.error("Here we go {} " + test.get().getReportId() + "client:" + clientService.getClientById(1L)
																							 .getReport()
																							 .getReportName());
		} else {
			LOG.error("empty reports");
		}
	}

	@PostMapping("/{clientId}/{reportId}")
	public void updateClientReport(@PathVariable Long clientId,
								   @PathVariable Long reportId) {

		ReportResponseData reportdto = reportService.getReportForClient(clientId, reportId);;
		if (reportdto != null) {
			clientService.addReportToClientById(clientId, reportdto);
			LOG.debug("Here we go {} " + reportdto.getReportId() + "client: " + clientService.getClientById(1L)
																							 .getReport()
																							 .getReportName());
		} else {
			LOG.error("empty report");
		}
	}
	@PatchMapping("/update")
	public void updateClientReportById(@RequestParam("clientId") Long clientId, //Update not to be void
									   @RequestParam("reportId") Long reportId) {

		List<ReportResponseData> reports = reportService.getReports();
		Optional<ReportResponseData> test = Optional.ofNullable(reports.stream()
																	   .filter(reportDTO -> reportId  == reportDTO.getReportId())
																	   .findAny()
																	   .orElseThrow(() -> new IllegalArgumentException("No such report")));
		if (test.isPresent()) {
			clientService.addReportToClientById(clientId, test.get());
			LOG.debug("Here we go {} " + test.get().getReportId() + "client: " + clientService.getClientById(1L)
																							  .getReport()
																							  .getReportName());
		} else {
			LOG.error("empty reports");
		}
	}
	@GetMapping
	public void getCustomerReports() {
		List<ReportResponseData> reports = reportService.getReports();
		Optional<ReportResponseData> test = reports.stream().findFirst();
		if(test.isPresent()) {
			LOG.error("Here we go {} " + test.get().getReportId() + ","	+ test.get().getReportName());
		} else {
			LOG.error("empty reports");
		}
	}

	@GetMapping("/demome") //demo demo
	public void demoCustomer() {
		Client client = new Client();
		clientRepository.save(client);
	}
}
