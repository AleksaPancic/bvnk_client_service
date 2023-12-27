package com.example.bvnk_client_service.service;

import com.example.bvnk_client_service.api.TransactionServiceAPI;
import com.example.bvnk_client_service.facade.impl.DefaultTransactionFacade;
import com.example.bvnk_client_service.util.function.CreateHeaderFunction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DefaultTransactionServiceTest {

	@InjectMocks
	DefaultTransactionFacade testingInstance;

	@Mock
	TransactionServiceAPI transactionServiceAPI;

	@Mock
	CreateHeaderFunction createHeaderFunction;

	private static final Long customerId = 1L;

	@BeforeTestClass
	public void setUp() {
		when(createHeaderFunction.createHeaders()).thenReturn(new HashMap<String, Object>());
	}

	@Test
	public void sendTransactionForCustomer_Success() {

	}
}
