package com.example.bvnk_client_service.api;

import com.example.bvnk_client_service.DTO.ReportDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


/**
 * This interface defines the methods that the client can use to interact with the reporting microservice.
 */
@FeignClient(name = "reportingMicroservice", url = "${reportMicroservice.url}")
public interface ReportingServiceAPI {

	/**
	 * This method is used to retrieve the report for a specific customer.
	 *
	 * @param headers The headers that contain the authentication information
	 * @param clientId The ID of the customer for whom the report is required
	 *
	 * @return A response containing the report data
	 */
	@GetMapping(value = "/client/{clientId}")
	ResponseEntity<ReportDTO> getReportForCustomer(@RequestHeader Map<String, Object> headers,
												   @PathVariable Long clientId);

	/**
	 * This method is used to create a report for a specific customer.
	 *
	 * @param headers The headers that contain the authentication information
	 * @param clientId The ID of the customer for whom the report is required
	 * @param report The report data to be created
	 *
	 * @return A response containing the report data
	 */
	@PostMapping("/report/update")
	ResponseEntity<ReportDTO> createReportForCustomer(@RequestHeader Map<String, Object> headers,
													  @RequestParam Long clientId,
													  @RequestBody ReportDTO report);

}
