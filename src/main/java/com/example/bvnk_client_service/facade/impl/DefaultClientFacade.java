package com.example.bvnk_client_service.facade.impl;

import com.example.bvnk_client_service.entity.Address;
import com.example.bvnk_client_service.entity.Client;
import com.example.bvnk_client_service.facade.ClientFacade;
import com.example.bvnk_client_service.repository.ClientDAO;
import com.example.bvnk_client_service.service.ClientService;
import com.example.bvnk_client_service.util.helper.ClientHelper;
import org.springframework.beans.factory.annotation.Autowired;


@Facade
public class DefaultClientFacade implements ClientFacade {

	private final ClientDAO clientDAO;
	private final ClientService clientService;
	private final ClientHelper clientHelper;

	@Autowired
	public DefaultClientFacade(final ClientDAO clientDAO, final ClientService clientService, final ClientHelper clientHelper) {
		this.clientDAO = clientDAO;
		this.clientService = clientService;
		this.clientHelper = clientHelper;
	}

	@Override
	public void makeADemoCustomerForTesting() {
		final Client client = new Client();
		clientDAO.save(client);
	}

	@Override
	public Address updateAddressForClient(final Long clientId, final Address address) {
		if(clientHelper.isCustomerIdValid(clientId)) {
			return clientService.updateAddressForClient(clientId, address);
		} else {
			throw new IllegalArgumentException("Invalid client id " + clientId);
		}
	}

}
