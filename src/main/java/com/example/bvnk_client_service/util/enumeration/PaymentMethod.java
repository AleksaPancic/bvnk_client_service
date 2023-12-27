package com.example.bvnk_client_service.util.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum PaymentMethod {
	CARD("Card"),
	BANK_TRANSFER("Bank Transfer"),
	PAYPAL("paypal"),
	APPLEPAY("applepay"),
	CRYPTO("crypto");

	private String description;

}
