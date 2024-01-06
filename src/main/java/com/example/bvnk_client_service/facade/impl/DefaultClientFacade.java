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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Facade
public class DefaultClientFacade implements ClientFacade {

	private final ClientDAO clientDAO;
	private final ClientService clientService;
	private final ClientHelper clientHelper;
	private final ReportService reportService;
	private final HistoryService historyService;

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
		final Client client = new Client();
		clientDAO.save(client);
	}

	@Override
	public Address updateAddressForClient(final Long clientId, final Address address) {
		if (clientHelper.isCustomerIdValid(clientId)) {
			return clientService.updateAddressForClient(clientId, address);
		} else {
			throw new IllegalArgumentException("Invalid client id " + clientId);
		}
	}

	@Override
	public Page<Client> getAllClientPages(final Pageable pageable) {
		return clientService.getAllClientPages(pageable);
	}

	@Override
	public Client deleteClient(final Long clientId) {

		final ReportDTO reportDTO = reportService.removeReportForClient(clientId);
		final HistoryDTO historyDTO = historyService.removeHistoryForClient(clientId);

		return clientService.deleteClient(clientId);
	}

	@Override
	public Address removeAddressForClient(final Long clientId) {
		if (clientHelper.isCustomerIdValid(clientId)) {
			return clientService.removeAddressForClient(clientId);
		} else {
			throw new IllegalArgumentException("Invalid client id " + clientId);
		}
	}

	@Override
	public Client updateFirstAndLastName(final Long clientId, final String firstName, final String lastName) {
		if(clientHelper.isCustomerIdValid(clientId)) {
			return clientService.updateFirstAndLastName(clientId, firstName, lastName);
		} else {
			throw new IllegalArgumentException("Invalid client id " + clientId);
		}
	}

	@Override
	public Long getNumberOfClientsInDatabase() {
		return clientService.getNumberOfClientsInDatabase();
	}

	@Override
	public Double getAvgYearsClient() {
		return clientService.getAvgYearsClient();
	}

}
