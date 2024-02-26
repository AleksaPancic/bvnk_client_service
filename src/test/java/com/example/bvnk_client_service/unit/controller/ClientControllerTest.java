package com.example.bvnk_client_service.unit.controller;

import com.example.bvnk_client_service.controller.ClientController;
import com.example.bvnk_client_service.entity.Client;
import com.example.bvnk_client_service.facade.ClientFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;

import static org.mockito.Mockito.times;


@ExtendWith(MockitoExtension.class)
public class ClientControllerTest {

	@InjectMocks
	private ClientController testingInstance;

	@Mock
	private ClientFacade clientFacade;

	@Mock
	private Client client;

	@Mock
	private BindingResult bindingResult;

	@Test
	public void createClient() {
		testingInstance.createClient(client, bindingResult);
		Mockito.verify(clientFacade, times(1)).createClient(client);
	}

	//TODO will be updated with business logic
}
