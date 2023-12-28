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
	public ReportDTO updateClientReport(final Long clientId, final ReportDTO report) throws IllegalArgumentException {
		LOG.info("Updating client report for client with id " + clientId);
		if (report != null) {
			return reportService.updateReportForClient(clientId, report);
		} else {
			throw new IllegalArgumentException("Invalid report");
		}
	}

	@Override
	public ReportDTO getReportForClient(final Long clientId) {
		LOG.info("Getting client report");
		if(clientId != null && clientDAO.findById(clientId).isPresent()) {
			return reportService.getReportForClient(clientId);
		} else {
			throw new IllegalArgumentException("Client id should not be null");
		}
	}

}
