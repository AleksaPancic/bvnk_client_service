package com.example.bvnk_client_service.unit.facade;

import com.example.bvnk_client_service.DTO.HistoryDTO;
import com.example.bvnk_client_service.entity.Client;
import com.example.bvnk_client_service.facade.impl.DefaultHistoryFacade;
import com.example.bvnk_client_service.repository.ClientDAO;
import com.example.bvnk_client_service.service.HistoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DefaultHistoryFacadeTest {

	@InjectMocks
	private DefaultHistoryFacade testingInstance;
	@Mock
	private HistoryService historyService;
	@Mock
	private ClientDAO clientDAO;
	@Mock
	private HistoryDTO historyDTO;

	private static final Long clientId = 1L;

	@Test
	public void getHistoryForClient_Success() {
		when(clientDAO.findById(clientId)).thenReturn(
				Optional.of(mock(Client.class)));
		when(historyService.getHistoryForClient(clientId)).thenReturn(historyDTO);
		HistoryDTO result = testingInstance.getHistoryForClient(clientId);
		assertThat(result).isEqualTo(historyDTO);
	}

	@Test
	public void getHistoryForClient_shouldThrowIllegalArgumentException() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
														  () -> testingInstance.getHistoryForClient(null));
		assertThat(exception.getMessage()).isEqualTo("Invalid client id null");
	}

}
