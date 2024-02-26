package com.example.bvnk_client_service.controller;

import com.example.bvnk_client_service.entity.Address;
import com.example.bvnk_client_service.entity.Client;
import com.example.bvnk_client_service.facade.ClientFacade;
import com.example.bvnk_client_service.response.AddressResponse;
import com.example.bvnk_client_service.response.ClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.example.bvnk_client_service.util.constants.ClientMicroserviceConstants.CLIENT_ID_NOT_NULL_MESSAGE_FORMAT;
import static com.example.bvnk_client_service.util.constants.ClientMicroserviceConstants.CREATED_SUCCESSFUL;
import static com.example.bvnk_client_service.util.constants.ClientMicroserviceConstants.FIRST_NAME_NOT_NULL_MESSAGE_FORMAT;
import static com.example.bvnk_client_service.util.constants.ClientMicroserviceConstants.LAST_NAME_NOT_NULL_MESSAGE_FORMAT;
import static com.example.bvnk_client_service.util.constants.ClientMicroserviceConstants.NOT_NULL_MESSAGE_FORMAT;
import static com.example.bvnk_client_service.util.constants.ClientMicroserviceConstants.PAGE_NOT_NULL_MESSAGE_FORMAT;
import static com.example.bvnk_client_service.util.constants.ClientMicroserviceConstants.UPDATED_SUCCESSFUL;
import static com.example.bvnk_client_service.util.constants.ClientMicroserviceConstants.VALIDATION_FAILURE;


@RestController
@RequestMapping("/clients")
public class ClientController {
	private final ClientFacade clientFacade;

	@Autowired
	public ClientController(final ClientFacade clientFacade) {
		this.clientFacade = clientFacade;
	}


	/*Create a client. The client request body should be something like:
	 * {
	 * "firstName": "John",
	 * "lastName": "Doe",
	 * "address": {
	 *   "street": "123 Main St",
	 *   "city": "Anytown",
	 * 	}
	 * }
	 */
	@PostMapping("/create")
	public ResponseEntity<ClientResponse> createClient(@Validated @RequestBody Client client, BindingResult bindingResult) {

		ClientResponse response = new ClientResponse();

		if (bindingResult.hasErrors()) {
			response.setMessage(String.format(VALIDATION_FAILURE, bindingResult.getAllErrors()));
			return ResponseEntity.badRequest().body(response);
		}
		response.setSuccess(true);
		response.setMessage(String.format(CREATED_SUCCESSFUL, Client.class.getSimpleName()));
		response.setData(clientFacade.createClient(client));

		return ResponseEntity.ok(response);
	}

	@PatchMapping("/update/address")
	public ResponseEntity<AddressResponse> updateAddress(@RequestParam Long clientId, @Validated @RequestBody Address address,
														 BindingResult bindingResult) {

		Objects.requireNonNull(clientId, CLIENT_ID_NOT_NULL_MESSAGE_FORMAT);
		Objects.requireNonNull(address, String.format(NOT_NULL_MESSAGE_FORMAT, Address.class.getSimpleName()));

		final AddressResponse response = new AddressResponse();

		if (bindingResult.hasErrors()) {
			response.setMessage(String.format(VALIDATION_FAILURE, bindingResult.getAllErrors()));
			return ResponseEntity.badRequest().body(response);
		}

		response.setSuccess(true);
		response.setMessage(String.format(UPDATED_SUCCESSFUL, Address.class.getSimpleName()));
		response.setData(clientFacade.updateAddressForClient(clientId, address));

		return ResponseEntity.ok(response);
	}

	@GetMapping("/{page}")
	public ResponseEntity<Page<Client>> getAllClientPages(@PathVariable Long page,
														  @PageableDefault(size = 10) Pageable pageable) {

		Objects.requireNonNull(page, PAGE_NOT_NULL_MESSAGE_FORMAT);

		pageable = PageRequest.of(page.intValue(), pageable.getPageSize(), pageable.getSort());
		return ResponseEntity.ok(clientFacade.getAllClientPages(pageable));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Client> deleteClient(@RequestParam Long clientId) {

		Objects.requireNonNull(clientId, CLIENT_ID_NOT_NULL_MESSAGE_FORMAT);

		return ResponseEntity.ok(clientFacade.deleteClient(clientId));
	}

	@PutMapping("/remove/address")
	public ResponseEntity<Address> removeAddress(@RequestParam Long clientId) {

		Objects.requireNonNull(clientId, CLIENT_ID_NOT_NULL_MESSAGE_FORMAT);

		return ResponseEntity.ok(clientFacade.removeAddressForClient(clientId));
	}

	@PatchMapping("/update/firstAndLastName")
	public ResponseEntity<Client> updateFirstAndLastName(@RequestParam Long clientId, @RequestParam String firstName,
														 @RequestParam
														 String lastName) { //this can be done with @RequestBody and custom obj

		Objects.requireNonNull(clientId, CLIENT_ID_NOT_NULL_MESSAGE_FORMAT);
		Objects.requireNonNull(firstName, FIRST_NAME_NOT_NULL_MESSAGE_FORMAT);
		Objects.requireNonNull(lastName, LAST_NAME_NOT_NULL_MESSAGE_FORMAT);

		return ResponseEntity.ok(clientFacade.updateFirstAndLastName(clientId, firstName, lastName));
	}

	@GetMapping("/country")
	public ResponseEntity<Map<Long, Address>> fetchClientsByCountry(@RequestParam String country) {
		return ResponseEntity.ok(clientFacade.fetchClientsByCountry(country));
	}

	@GetMapping("/count")
	public ResponseEntity<Long> countClients() {
		return ResponseEntity.ok(clientFacade.getNumberOfClientsInDatabase());
	}

	@GetMapping("/avg")
	public ResponseEntity<Double> getAvgYearsClient() {
		return ResponseEntity.ok(clientFacade.getAvgYearsClient());
	}

	@GetMapping("/isMinor")
	public ResponseEntity<Boolean> isMinor(@RequestParam Long clientId) {
		return ResponseEntity.ok(clientFacade.isMinor(clientId));
	}

	@GetMapping("/fetchMinorClients")
	public ResponseEntity<List<Client>> fetchMinorClients() {
		return ResponseEntity.ok(clientFacade.getAllClientsMinors());
	}

	@GetMapping("/fetchClientsDisplayMinority")
	public ResponseEntity<Map<Client, Boolean>> fetchClientsDisplayMinority() {
		return ResponseEntity.ok(clientFacade.isMinorForAllClients());
	}

}