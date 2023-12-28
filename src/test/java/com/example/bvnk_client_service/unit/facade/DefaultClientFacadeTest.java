package com.example.bvnk_client_service.unit.facade;

import com.example.bvnk_client_service.entity.Client;
import com.example.bvnk_client_service.facade.impl.DefaultClientFacade;
import com.example.bvnk_client_service.repository.ClientDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
public class DefaultClientFacadeTest {

	@InjectMocks
	private DefaultClientFacade clientFacade;

	@Mock
	private ClientDAO clientDAO;

	@Test
    public void makeADemoCustomerForTesting() {
        clientFacade.makeADemoCustomerForTesting();
		Mockito.verify(clientDAO, Mockito.times(1)).save(any(Client.class));
    }

}
