package com.example.bvnk_client_service.controller;

import com.example.bvnk_client_service.facade.ClientFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/clients")
public class ClientController {
	private final ClientFacade clientFacade;

	@Autowired
	public ClientController(final ClientFacade clientFacade) {
		this.clientFacade = clientFacade;
	}


	//Create an empty client for report testing
	@GetMapping("/createDemoCustomer")
	public void demoCustomer() {
		clientFacade.makeADemoCustomerForTesting();
	}

	//TODO will be updated with business logic
}
