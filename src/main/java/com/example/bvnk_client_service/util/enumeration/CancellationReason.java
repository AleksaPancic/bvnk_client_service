package com.example.bvnk_client_service.util.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum CancellationReason {
	DENIED_PAYMENT("The payment was denied"),
	CANCELLED_TRANSACTION("The transaction was canceled");

	private final String description;

}
