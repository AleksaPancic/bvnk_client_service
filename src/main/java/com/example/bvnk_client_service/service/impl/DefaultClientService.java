package com.example.bvnk_client_service.service.impl;

import com.example.bvnk_client_service.entity.Address;
import com.example.bvnk_client_service.entity.Client;
import com.example.bvnk_client_service.populator.Populator;
import com.example.bvnk_client_service.repository.ClientDAO;
import com.example.bvnk_client_service.service.ClientService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;


@Service
public class DefaultClientService implements ClientService {
	private final ClientDAO clientDAO;
	private final Populator<Address, Address> populator;

	@Autowired
	public DefaultClientService(final ClientDAO clientDAO, final Populator<Address, Address> populator) {
		this.clientDAO = clientDAO;
		this.populator = populator;
	}

	@Override
	public Client getClientById(final Long clientId) throws RuntimeException {
		try {
			return clientDAO.getReferenceById(clientId);
		} catch (Exception e) {
			throw new RuntimeException("An unexpected error occurred while getting client by ID " + clientId, e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Address updateAddressForClient(final Long clientId, final Address address) {
		final Client client = getClientById(clientId);
		final Address existingAddress = client.getAddress();

		if (existingAddress != null) {
			populator.populate(address, existingAddress);
			client.setAddress(existingAddress);
		} else {
			client.setAddress(address);
		}

		clientDAO.save(client);

		return client.getAddress();
	}

}
