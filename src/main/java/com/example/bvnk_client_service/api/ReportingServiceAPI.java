package com.example.bvnk_client_service.api;

import com.example.bvnk_client_service.DTO.response.TransactionResponseData;
import feign.HeaderMap;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.Map;


/**
 * This interface defines the methods that the client can use to interact with the Reporting Service API.
 * The interface is annotated with the FeignClient annotation, which tells Spring Cloud to generate a proxy
 * class for the API that can be used to make calls to the service. The name of the proxy class is
 * determined by combining the value of the name attribute with the default Feign client suffix.
 * The url attribute specifies the URL of the service to which the client should connect.
 * The interface contains two methods: getReportForCustomer and createReportForCustomer.
 * The getReportForCustomer method is a GET request that retrieves a report for a specific customer.
 * The method is annotated with the RequestLine annotation, which specifies the HTTP method and request
 * path. The headers attribute is used to specify the headers that should be included in the request.
 * The customerId and reportingId parameters are used to pass the customer ID and reporting ID values
 * to the service. The method returns a TransactionResponseData object, which contains the report data.
 * The createReportForCustomer method is a POST request that creates a report for a specific customer.
 * The method is annotated with the RequestLine annotation, which specifies the HTTP method and request
 * path. The headers attribute is used to specify the headers that should be included in the request.
 * The customerId and reportingId parameters are used to pass the customer ID and reporting ID values
 * to the service. The method returns a TransactionResponseData object, which contains the report data.
 */
@FeignClient(name="reportingMicroservice", url="${reportMicroservice.url}")
public interface ReportingServiceAPI {

    /**
     * This method is a GET request that retrieves a report for a specific customer.
     * @param headers a map of headers that should be included in the request
     * @param customerId the ID of the customer for whom the report is being retrieved
     * @param reportingId the ID of the report to retrieve
     * @return a TransactionResponseData object containing the report data
     */
    @RequestLine("GET")
    TransactionResponseData getReportForCustomer(@HeaderMap Map<String, Object> headers,
                                                 @Param("customerId") String customerId,
                                                 @Param("reportingId") String reportingId);

    /**
     * This method is a POST request that creates a report for a specific customer.
     * @param headers a map of headers that should be included in the request
     * @param customerId the ID of the customer for whom the report is being created
     * @param reportingId the ID of the report to create
     * @return a TransactionResponseData object containing the report data
     */
    @RequestLine("POST")
    TransactionResponseData createReportForCustomer(@HeaderMap Map<String, Object> headers,
                                                    @Param("customerId") String customerId,
                                                    @Param("reportingId") String reportingId);

}
