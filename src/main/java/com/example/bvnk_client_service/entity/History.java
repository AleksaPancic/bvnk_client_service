package com.example.bvnk_client_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "history")
@Data
public class History {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long historyId;
	private String historyName;
	private String historyDescription;
}
