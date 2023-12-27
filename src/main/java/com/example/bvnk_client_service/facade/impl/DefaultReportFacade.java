package com.example.bvnk_client_service.facade.impl;


import com.example.bvnk_client_service.DTO.ReportDTO;
import com.example.bvnk_client_service.controller.ReportController;
import com.example.bvnk_client_service.entity.Client;
import com.example.bvnk_client_service.facade.ReportFacade;
import com.example.bvnk_client_service.repository.ClientDAO;
import com.example.bvnk_client_service.service.ClientService;
import com.example.bvnk_client_service.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


@Facade
public class DefaultReportFacade implements ReportFacade {
	private final static Logger LOG = LoggerFactory.getLogger(ReportController.class);

	private final ReportService reportService;
	private final ClientService clientService;
	private final ClientDAO clientDAO;

	@Autowired
	public DefaultReportFacade(final ReportService reportService, final ClientService clientService,
							   final ClientDAO clientDAO) {
		this.reportService = reportService;
		this.clientService = clientService;
		this.clientDAO = clientDAO;
	}

	@Override
	public ReportDTO updateClientReport(final Long clientId, final ReportDTO report) { // TODO
		LOG.info("Updating client report");
		return reportService.updateReportForClient(clientId, report);
	}

	@Override
	public void makeADemoCustomerForTesting() {
		final Client client = new Client();
		clientDAO.save(client);
	}

	@Override
	public ReportDTO getReportForClient(final Long clientId) {
		LOG.info("Getting client report");
		return reportService.getReportForClient(clientId);
	}

}
