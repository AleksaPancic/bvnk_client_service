package com.example.bvnk_client_service.facade;

import com.example.bvnk_client_service.DTO.response.ReportResponseData;


/**
 * This interface provides methods for interacting with the report data.
 */
public interface ReportFacade {

    /**
     * Updates the report data for a specific client.
     *
     * @param clientId the ID of the client
     * @param reportId the ID of the report
     */
    void updateClientReport(Long clientId, Long reportId);

    /**
     * Creates a demo customer for testing purposes.
     */
    void makeADemoCustomerForTesting();

    /**
     * Retrieves the report data for a specific client.
     *
     * @param clientId the ID of the client
     * @return the report data for the specified client
     */
    ReportResponseData getReportForClient(Long clientId);

}
