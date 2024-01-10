package com.example.bvnk_client_service.integration.facade;

import com.example.bvnk_client_service.DTO.HistoryDTO;
import com.example.bvnk_client_service.facade.HistoryFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class HistoryFacadeIntegrationTest {

	private final HistoryFacade historyFacade;

	private static final Long clientId = 1L;

	@Autowired
	public HistoryFacadeIntegrationTest(final HistoryFacade historyFacade) {
		this.historyFacade = historyFacade;
	}
/*
	@Test
	public void getHistoryForClient_Success() {
		final HistoryDTO historyDTO = historyFacade.getHistoryForClient(clientId);
		assertThat(historyDTO).isNotNull();
		assertThat(historyDTO.getClientId()).isEqualTo(clientId);
		assertThat(historyDTO).isInstanceOf(HistoryDTO.class);
	}

	@Test
	public void getHistoryForClient_Fail_shouldThrowIllegalArgumentException() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
														  () -> historyFacade.getHistoryForClient(null));

		assertThat(exception.getMessage()).contains("Invalid client id ");
	}*/
}
