package com.example.bvnk_client_service.response;

import com.example.bvnk_client_service.entity.Client;
import lombok.Data;

@Data
public class ClientResponse {
	private Boolean success;
	private String message;
	Client data;
}
