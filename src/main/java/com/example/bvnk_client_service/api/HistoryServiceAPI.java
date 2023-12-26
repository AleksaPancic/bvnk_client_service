package com.example.bvnk_client_service.api;

import com.example.bvnk_client_service.DTO.response.TransactionResponseData;
import feign.HeaderMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


/**
 * This interface defines the contract for the History Service API.
 * The History Service API is used to retrieve customer transaction history data.
 */
@FeignClient(name="historyMicroservice", url="${historyMicroservice.url}")
public interface HistoryServiceAPI {

    /**
     * This method is used to retrieve a customer's transaction history data.
     *
     * @param headers a map of request headers
     * @param clientId the customer ID
     * @param reportingId the reporting ID
     * @return the transaction history data
     */
    @GetMapping
    TransactionResponseData getHistoryForCustomer(@HeaderMap Map<String,Object> headers,
                                                  @RequestParam("clientId") String clientId,
                                                  @RequestParam("historyId") String reportingId);
}

