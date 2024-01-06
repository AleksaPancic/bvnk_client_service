package com.example.bvnk_client_service.integration.controller;

import com.example.bvnk_client_service.controller.ClientController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ClientControllerIntegrationTest {

	private final ClientController clientController;

	@Autowired
	public ClientControllerIntegrationTest(final ClientController clientController) {
		this.clientController = clientController;
	}

	@Test
	public void createDemoCustomerSuccess() {
        clientController.demoCustomer(); //TODO Auto
    }

}
