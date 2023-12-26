package com.example.bvnk_client_service.facade.impl;


import com.example.bvnk_client_service.DTO.response.ReportResponseData;
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
	public void updateClientReport(final Long clientId, final Long reportId) {
		final ReportResponseData reportdto = reportService.updateReportForClient(clientId, reportId);
		if (reportdto != null) {
			clientService.addReportToClientById(clientId, reportdto);
			LOG.debug("Here we go {} " + reportdto.getReportId() + "client: " + clientService.getClientById(clientId)
																							 .getReport()
																							 .getReportName());
		} else {
			LOG.error("empty report");
		}
	}

	@Override
	public void makeADemoCustomerForTesting() {
		final Client client = new Client();
		clientDAO.save(client);
	}

	@Override
	public ReportResponseData getReportForClient(final Long clientId) {
		return reportService.getReportForClient(clientId);
	}
}
