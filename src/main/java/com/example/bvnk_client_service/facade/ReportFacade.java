package com.example.bvnk_client_service.facade;

import com.example.bvnk_client_service.DTO.ReportDTO;


/**
 * This interface provides methods for interacting with the report data.
 */
public interface ReportFacade {
	/**
	 * Updates the report data for a specific client.
	 *
	 * @param clientId the ID of the client for which to update the report
	 * @param report the new report data
     *
	 */
	ReportDTO updateClientReport(Long clientId, ReportDTO report);

	/**
	 * Creates a demo customer for testing purposes.
	 */
	void makeADemoCustomerForTesting();

	/**
	 * Retrieves the report data for a specific client.
	 *
	 * @param clientId the ID of the client
	 *
	 * @return the report data for the specified client
	 */
	ReportDTO getReportForClient(Long clientId);

}
