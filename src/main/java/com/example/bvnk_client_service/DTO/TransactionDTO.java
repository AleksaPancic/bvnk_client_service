package com.example.bvnk_client_service.DTO;

import com.example.bvnk_client_service.util.enumeration.CancellationReason;
import com.example.bvnk_client_service.util.enumeration.PaymentMethod;
import com.example.bvnk_client_service.util.enumeration.TransactionStatus;
import lombok.Data;

@Data
public class TransactionDTO {
	private PaymentMethod paymentMethod;
	private CancellationReason cancellationReason;
	private TransactionStatus transactionStatus;

}
