package com.example.bvnk_client_service.DTO;

import com.example.bvnk_client_service.util.enumeration.CancellationReason;
import com.example.bvnk_client_service.util.enumeration.PaymentMethod;
import com.example.bvnk_client_service.util.enumeration.TransactionStatus;
import lombok.Data;

@Data
public class TransactionDTO {
	private Long clientId; //reference to the client
	private PaymentMethod paymentMethod;
	private Double paymentAmount;
	private CancellationReason cancellationReason;
	private TransactionStatus transactionStatus;

}
