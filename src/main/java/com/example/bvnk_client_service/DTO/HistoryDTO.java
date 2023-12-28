package com.example.bvnk_client_service.DTO;

import lombok.Data;


@Data
public class HistoryDTO {
	private Long clientId; //reference to the client
	private String historyName;
	private String historyDescription;
	private String historyContent;

}
