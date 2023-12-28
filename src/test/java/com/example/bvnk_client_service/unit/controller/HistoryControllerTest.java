package com.example.bvnk_client_service.unit.controller;

import com.example.bvnk_client_service.controller.HistoryController;
import com.example.bvnk_client_service.facade.HistoryFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;


@ExtendWith(MockitoExtension.class)
public class HistoryControllerTest {

	@InjectMocks
	private HistoryController testingInstance;

	@Mock
	private HistoryFacade historyFacade;

	@Test
	public void getHistoryForClient() {
		testingInstance.getHistoryForClient(1L);
		Mockito.verify(historyFacade, times(1)).getHistoryForClient(1L);
	}

}
