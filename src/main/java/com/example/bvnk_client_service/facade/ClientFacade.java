package com.example.bvnk_client_service.facade;

import com.example.bvnk_client_service.entity.Address;


public interface ClientFacade {

	/**
	 * Creates a demo customer for testing purposes.
	 */
	void makeADemoCustomerForTesting();

	Address updateAddressForClient(Long clientId, Address address);

}
