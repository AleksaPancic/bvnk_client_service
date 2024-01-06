package com.example.bvnk_client_service.controller;

import com.example.bvnk_client_service.entity.Address;
import com.example.bvnk_client_service.entity.Client;
import com.example.bvnk_client_service.facade.ClientFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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


	//Create an empty client for report testing, using void not rec approach, but its just for testing :)
	@PostMapping("/createDemoClient")
	public void demoCustomer() {
		clientFacade.makeADemoCustomerForTesting();
	}

	@PatchMapping("/update/address")
	public ResponseEntity<Address> updateAddress(@RequestParam Long clientId, @RequestBody Address address) {
		Objects.requireNonNull(clientId, "Client id cannot be null");
		Objects.requireNonNull(address, "Address cannot be null");

		return ResponseEntity.ok(clientFacade.updateAddressForClient(clientId, address));
	}

	@GetMapping("/{page}")
	public ResponseEntity<Page<Client>> getAllClientPages(@PathVariable Long page,
														  @PageableDefault(size = 10) Pageable pageable) {

		Objects.requireNonNull(page, "Page cannot be null");

		pageable = PageRequest.of(page.intValue(), pageable.getPageSize(), pageable.getSort());
		return ResponseEntity.ok(clientFacade.getAllClientPages(pageable));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Client> deleteClient(@RequestParam Long clientId) {

		Objects.requireNonNull(clientId, "Client id cannot be null");

		return ResponseEntity.ok(clientFacade.deleteClient(clientId));
	}

	@PutMapping("/remove/address")
	public ResponseEntity<Address> removeAddress(@RequestParam Long clientId) {

		Objects.requireNonNull(clientId, "Client id cannot be null");

		return ResponseEntity.ok(clientFacade.removeAddressForClient(clientId));
	}

	@PatchMapping("/update/firstAndLastName")
	public ResponseEntity<Client> updateFirstAndLastName(@RequestParam Long clientId, @RequestParam String firstName,
														 @RequestParam
														 String lastName) { //this can be done with @RequestBody and custom obj

		Objects.requireNonNull(clientId, "Client id cannot be null");
		Objects.requireNonNull(firstName, "First name cannot be null");
		Objects.requireNonNull(lastName, "Last name cannot be null");

		return ResponseEntity.ok(clientFacade.updateFirstAndLastName(clientId, firstName, lastName));
	}

	@GetMapping("/count")
	public ResponseEntity<Long> countClients() {
		return ResponseEntity.ok(clientFacade.getNumberOfClientsInDatabase());
	}

	@GetMapping("/avg")
	public ResponseEntity<Double> getAvgYearsClient() {
		return ResponseEntity.ok(clientFacade.getAvgYearsClient());
	}

}