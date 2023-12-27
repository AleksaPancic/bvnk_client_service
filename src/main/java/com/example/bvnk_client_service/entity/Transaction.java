package com.example.bvnk_client_service.entity;

import com.example.bvnk_client_service.util.constants.PaymentMethod;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "transactions")
@Data
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;

	private PaymentMethod paymentMethod;

	@ManyToOne
	@JoinColumn(name = "client_id", referencedColumnName = "clientId")
	private Client client;

	@OneToOne
	@JoinColumn(name = "address_id", referencedColumnName = "addressId")
	private Address address;

}
