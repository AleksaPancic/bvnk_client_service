package com.example.bvnk_client_service.util.helper.impl;

import com.example.bvnk_client_service.repository.ClientDAO;
import com.example.bvnk_client_service.util.helper.CustomerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DefaultCustomerHelper implements CustomerHelper {

	private final ClientDAO clientDAO;

	@Autowired
	public DefaultCustomerHelper(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}

	@Override
	public Boolean isCustomerIdValid(final Long clientId) {
		return clientDAO.findById(clientId).isPresent();
	}

}
