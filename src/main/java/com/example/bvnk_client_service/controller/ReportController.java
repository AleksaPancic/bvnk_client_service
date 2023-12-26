package com.example.bvnk_client_service.controller;

import com.example.bvnk_client_service.DTO.response.ReportResponseData;
import com.example.bvnk_client_service.entity.Client;
import com.example.bvnk_client_service.repository.ClientDAO;
import com.example.bvnk_client_service.service.ClientService;
import com.example.bvnk_client_service.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/report")
public class ReportController {

	private ReportService reportService;
	private ClientService clientService;
	private ClientDAO clientDAO;
	private final static Logger LOG = LoggerFactory.getLogger(ReportController.class);

	@Autowired
	public ReportController(ReportService reportService, ClientService clientService, ClientDAO clientDAO) {
		this.reportService = reportService;
		this.clientService = clientService;
		this.clientDAO = clientDAO;
	}

	@GetMapping
	public ReportResponseData getReportForClient(@RequestParam Long clientId) {
		return reportService.getReportForClient(clientId);
	}

	@PostMapping("/update")
	public void updateClientReport(@RequestParam Long clientId,
								   @RequestParam Long reportId) { //TODO try catch and transfer to Facade

		ReportResponseData reportdto = reportService.updateReportForClient(clientId, reportId);
		if (reportdto != null) {
			clientService.addReportToClientById(clientId, reportdto);
			LOG.debug("Here we go {} " + reportdto.getReportId() + "client: " + clientService.getClientById(clientId)
																							 .getReport()
																							 .getReportName());
		} else {
			LOG.error("empty report");
		}
	}

	@GetMapping("/demome") //Create empty client
	public void demoCustomer() {
		Client client = new Client();
		clientDAO.save(client);
	}
}
