package com.example.bvnk_client_service.DTO;

import com.example.bvnk_client_service.util.constants.CancellationReason;
import com.example.bvnk_client_service.util.constants.PaymentMethod;
import com.example.bvnk_client_service.util.constants.TransactionStatus;
import lombok.Data;

@Data
public class TransactionDTO {
	private PaymentMethod paymentMethod;
	private CancellationReason cancellationReason;
	private TransactionStatus transactionStatus;

}
