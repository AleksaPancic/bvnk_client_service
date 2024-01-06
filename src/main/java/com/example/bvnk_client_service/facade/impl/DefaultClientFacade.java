package com.example.bvnk_client_service.facade.impl;

import com.example.bvnk_client_service.DTO.HistoryDTO;
import com.example.bvnk_client_service.DTO.ReportDTO;
import com.example.bvnk_client_service.entity.Address;
import com.example.bvnk_client_service.entity.Client;
import com.example.bvnk_client_service.facade.ClientFacade;
import com.example.bvnk_client_service.repository.ClientDAO;
import com.example.bvnk_client_service.service.ClientService;
import com.example.bvnk_client_service.service.HistoryService;
import com.example.bvnk_client_service.service.ReportService;
import com.example.bvnk_client_service.util.helper.ClientHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static com.example.bvnk_client_service.util.constants.ClientMicroserviceConstants.INVALID_CLIENT_ID;


@Facade
public class DefaultClientFacade implements ClientFacade {

	private final ClientDAO clientDAO;
	private final ClientService clientService;
	private final ClientHelper clientHelper;
	private final ReportService reportService;
	private final HistoryService historyService;

	private final static Logger LOG = LoggerFactory.getLogger(DefaultClientFacade.class);

	@Autowired
	public DefaultClientFacade(final ClientDAO clientDAO, final ClientService clientService, final ClientHelper clientHelper,
							   final ReportService reportService, final HistoryService historyService) {
		this.clientDAO = clientDAO;
		this.clientService = clientService;
		this.clientHelper = clientHelper;
		this.reportService = reportService;
		this.historyService = historyService;
	}

	@Override
	public void makeADemoCustomerForTesting() {
		LOG.info("Making a demo customer for testing");
		final Client client = new Client();
		clientDAO.save(client);
	}

	@Override
	public Address updateAddressForClient(final Long clientId, final Address address) {
		if (clientHelper.isCustomerIdValid(clientId)) {
			LOG.info("Updating address for client with id " + clientId);
			return clientService.updateAddressForClient(clientId, address);
		} else {
			throw new IllegalArgumentException(String.format(INVALID_CLIENT_ID, clientId));
		}
	}

	@Override
	public Page<Client> getAllClientPages(final Pageable pageable) {
		LOG.info("Fetching all clients");
		return clientService.getAllClientPages(pageable);
	}

	@Override
	public Client deleteClient(final Long clientId) {
		LOG.info("Removing report for client with id " + clientId);
		final ReportDTO reportDTO = reportService.removeReportForClient(clientId);
		LOG.info("Removing history for client with id " + clientId);
		final HistoryDTO historyDTO = historyService.removeHistoryForClient(clientId);
		LOG.info("Deleting client with id " + clientId);
		return clientService.deleteClient(clientId);
	}

	@Override
	public Address removeAddressForClient(final Long clientId) {
		if (clientHelper.isCustomerIdValid(clientId)) {
			LOG.info("Removing address for client with id " + clientId);
			return clientService.removeAddressForClient(clientId);
		} else {
			throw new IllegalArgumentException(String.format(INVALID_CLIENT_ID, clientId));
		}
	}

	@Override
	public Client updateFirstAndLastName(final Long clientId, final String firstName, final String lastName) {
		if(clientHelper.isCustomerIdValid(clientId)) {
			LOG.info("Updating first and last name for client with id " + clientId);
			return clientService.updateFirstAndLastName(clientId, firstName, lastName);
		} else {
			throw new IllegalArgumentException(String.format(INVALID_CLIENT_ID, clientId));
		}
	}

	@Override
	public Long getNumberOfClientsInDatabase() {
		LOG.info("Fetching number of clients in database");
		return clientService.getNumberOfClientsInDatabase();
	}

	@Override
	public Double getAvgYearsClient() {
		LOG.info("Fetching average years client");
		return clientService.getAvgYearsClient();
	}

}
