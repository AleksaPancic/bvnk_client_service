package com.example.bvnk_client_service.controller;

import com.example.bvnk_client_service.entity.Address;
import com.example.bvnk_client_service.facade.ClientFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;


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

	@PatchMapping("/update/address")
	public Address updateAddress(@RequestParam Long clientId, @RequestBody Address address) {
		Objects.requireNonNull(clientId, "Client id cannot be null");
		Objects.requireNonNull(address, "Address cannot be null");

		return clientFacade.updateAddressForClient(clientId, address);
	}


}
