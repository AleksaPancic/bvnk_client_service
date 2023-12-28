package com.example.bvnk_client_service.service.impl;

import com.example.bvnk_client_service.entity.Client;
import com.example.bvnk_client_service.repository.ClientDAO;
import com.example.bvnk_client_service.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DefaultClientService implements ClientService {
	private final ClientDAO clientDAO;

	@Autowired
	public DefaultClientService(final ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}

	@Override
	public Client getClientById(final Long clientId) {
		return clientDAO.getReferenceById(clientId);
	}

}
