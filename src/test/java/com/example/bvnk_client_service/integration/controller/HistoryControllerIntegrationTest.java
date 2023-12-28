package com.example.bvnk_client_service.integration.controller;

import com.example.bvnk_client_service.DTO.HistoryDTO;
import com.example.bvnk_client_service.controller.HistoryController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class HistoryControllerIntegrationTest {

	private final HistoryController historyController;

	private static final Long clientId = 1L;

	@Autowired
	public HistoryControllerIntegrationTest(HistoryController historyController) {
		this.historyController = historyController;
	}

	@Test
	public void getHistory_Success() {
        HistoryDTO historyDTO = historyController.getHistoryForClient(clientId);
		assertThat(historyDTO).isNotNull();
		assertThat(historyDTO).isInstanceOf(HistoryDTO.class);
	}

	@Test
	public void getHistory_Failure_ShouldThrowIllegalArgumentException() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                                                          () -> historyController.getHistoryForClient(null));

        assertThat(exception.getMessage()).contains("Invalid client id");
	}

}
