package com.example.bvnk_client_service.response;

import com.example.bvnk_client_service.entity.Address;
import lombok.Data;

@Data
public class AddressResponse {
	private Boolean success;
	private String message;
	private Address data;
}
