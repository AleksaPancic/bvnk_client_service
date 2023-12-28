package com.example.bvnk_client_service.unit.service;

import com.example.bvnk_client_service.entity.Client;
import com.example.bvnk_client_service.repository.ClientDAO;
import com.example.bvnk_client_service.service.impl.DefaultClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DefaultClientServiceTest {

	@InjectMocks
	private DefaultClientService defaultClientService;

	@Mock
	private ClientDAO clientDAO;

	@Mock
	private Client client;

	private static final Long clientId = 1L;

	@Test
	public void testGetClientById_Success() {
		when(clientDAO.getReferenceById(clientId)).thenReturn(client);
		Client result = defaultClientService.getClientById(clientId);
		assertThat(result.getClientId()).isEqualTo(client.getClientId());
	}

}
