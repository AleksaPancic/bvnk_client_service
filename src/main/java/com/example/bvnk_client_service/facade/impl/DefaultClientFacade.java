package com.example.bvnk_client_service.facade.impl;

import com.example.bvnk_client_service.entity.Client;
import com.example.bvnk_client_service.facade.ClientFacade;
import com.example.bvnk_client_service.repository.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;


@Facade
public class DefaultClientFacade implements ClientFacade {

	private final ClientDAO clientDAO;

	@Autowired
	public DefaultClientFacade(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}

	@Override
	public void makeADemoCustomerForTesting() {
		final Client client = new Client();
		clientDAO.save(client);
	}

}
