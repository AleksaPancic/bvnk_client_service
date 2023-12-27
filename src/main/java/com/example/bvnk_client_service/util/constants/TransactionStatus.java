package com.example.bvnk_client_service.util.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum TransactionStatus {
	PENDING("PENDING"),
	CONFIRMED("CONFIRMED"),
	CANCELLED("CANCELLED");

	private String description;
}
