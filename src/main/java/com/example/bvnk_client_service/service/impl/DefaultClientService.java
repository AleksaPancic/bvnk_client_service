package com.example.bvnk_client_service.service.impl;

import com.example.bvnk_client_service.entity.Address;
import com.example.bvnk_client_service.entity.Client;
import com.example.bvnk_client_service.populator.Populator;
import com.example.bvnk_client_service.repository.ClientDAO;
import com.example.bvnk_client_service.service.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.query.InvalidJpaQueryMethodException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import java.util.Optional;


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
	@Transactional(readOnly = true) //not on a class level as this service can have methods that are not transactional
	public Client getClientById(final Long clientId) throws RuntimeException {
		try {
			return clientDAO.getReferenceById(clientId);
		} catch (Exception e) {
			throw new InvalidJpaQueryMethodException(String.format("An unexpected error occurred while getting client by ID %d" , clientId));
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Address updateAddressForClient(final Long clientId, final Address address) {
		final Client client = getClientById(clientId);

		if (client == null) {
			throw new IllegalArgumentException("Client with id " + clientId + " does not exist");
		}

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

	@Override
	@Transactional(readOnly = true)
	public Page<Client> getAllClientPages(final Pageable pageable) {
		try {
			return clientDAO.findAll(pageable);
		} catch (Exception e) {
			throw new InvalidJpaQueryMethodException("An unexpected error occurred while fetching client pages " + e.getMessage());
		}
	}

	@Override
	@Transactional
	public Client deleteClient(final Long clientId) {
		final Optional<Client> client = clientDAO.findById(clientId);
		if (client.isPresent()) {
			clientDAO.deleteById(clientId);
			return client.get();
		} else {
			throw new IllegalArgumentException("Client with id " + clientId + " does not exist");
		}
	}

	@Override
	@Transactional
	public void removeAddressForClient(Long clientId) {
		clientDAO.deleteAddressByClientId(clientId);
	}

	@Override
	@Transactional
	public void updateFirstAndLastName(Long clientId, String firstName, String lastName) {
		clientDAO.updateFirstAndLastName(clientId, firstName, lastName);
	}

	@Override
	public Long getNumberOfClientsInDatabase() {
		return clientDAO.numberOfClientsInDatabase();
	}

	@Override
	public Double getAvgYearsClient() {
		return clientDAO.avgYearsClient();
	}

	//make a custom logic for age of client, to be minor or not minor
}
