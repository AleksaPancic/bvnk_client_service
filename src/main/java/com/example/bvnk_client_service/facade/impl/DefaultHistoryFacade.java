package com.example.bvnk_client_service.facade.impl;

import com.example.bvnk_client_service.DTO.HistoryDTO;
import com.example.bvnk_client_service.controller.ReportController;
import com.example.bvnk_client_service.facade.HistoryFacade;
import com.example.bvnk_client_service.repository.ClientDAO;
import com.example.bvnk_client_service.service.HistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static com.example.bvnk_client_service.util.constants.ClientMicroserviceConstants.INVALID_CLIENT_ID;


@Facade
public class DefaultHistoryFacade implements HistoryFacade {

	private final HistoryService historyService;
	private final ClientDAO clientDAO;

	private final static Logger LOG = LoggerFactory.getLogger(DefaultHistoryFacade.class);

	@Autowired
	public DefaultHistoryFacade(final HistoryService historyService, final ClientDAO clientDAO) {
		this.historyService = historyService;
		this.clientDAO = clientDAO;
	}

	@Override
	public HistoryDTO getHistoryForClient(final Long clientId) throws IllegalArgumentException {
		LOG.info("Fetching client history");
		if (clientId == null || !clientDAO.findById(clientId).isPresent()) {
			throw new IllegalArgumentException(String.format(INVALID_CLIENT_ID, clientId));
		}
		return historyService.getHistoryForClient(clientId);
	}

}
