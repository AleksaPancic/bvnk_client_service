package com.example.bvnk_client_service.integration.facade;

import com.example.bvnk_client_service.facade.ClientFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ClientFacadeIntegrationTest {

	private final ClientFacade clientFacade;

	@Autowired
	public ClientFacadeIntegrationTest(ClientFacade clientFacade) {
		this.clientFacade = clientFacade;
	}

	@Test
	public void makeADemoCustomerForTesting() {
       clientFacade.makeADemoCustomerForTesting(); //TODO Auto
    }
}
