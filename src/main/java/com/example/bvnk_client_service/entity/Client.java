package com.example.bvnk_client_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Table(name = "clients")
@Data
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long clientId;

	@OneToOne
	@JoinColumn(name = "report_Id", referencedColumnName = "reportId")
	private Report report;

	@OneToOne
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;
}
