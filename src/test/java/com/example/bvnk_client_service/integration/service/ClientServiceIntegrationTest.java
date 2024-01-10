package com.example.bvnk_client_service.integration.service;

import com.example.bvnk_client_service.entity.Client;
import com.example.bvnk_client_service.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class ClientServiceIntegrationTest {

	private final ClientService clientService;

	private static final Long clientId = 1L;

	@Autowired
	public ClientServiceIntegrationTest(final ClientService clientService) {
		this.clientService = clientService;
	}
/*
	@Test
    public void createClient_Success() throws RuntimeException {
       Client client =  clientService.getClientById(clientId);
	   assertThat(client).isNotNull();
	   assertThat(client.getClientId()).isEqualTo(clientId);
    }

	@Test
	public void createClient_Failure() throws RuntimeException {
		assertThrows(RuntimeException.class, () -> clientService.getClientById(null));
	}
*/

}
