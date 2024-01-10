package com.example.bvnk_client_service.integration.service;

import com.example.bvnk_client_service.DTO.ReportDTO;
import com.example.bvnk_client_service.api.ReportingServiceAPI;
import com.example.bvnk_client_service.service.ReportService;
import com.example.bvnk_client_service.service.impl.DefaultReportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class ReportServiceIntegrationTest {

	private final ReportService reportService;

	private static final Long clientId = 1L;

	private static ReportDTO reportDTO;

	private final static Logger LOG = LoggerFactory.getLogger(DefaultReportService.class);

	@BeforeTestClass
	public static void beforeClass() {
		LOG.info("ReportServiceIntegrationTest started");
	}

	@BeforeEach
	void setUp() {
		reportDTO = new ReportDTO();
	}


	@Autowired
	public ReportServiceIntegrationTest(final ReportService reportService, ReportingServiceAPI reportingServiceAPI) {
		this.reportService = reportService;
	}

/*
	@Test
	public void updateReportForClientSuccess() throws IllegalStateException {
		ReportDTO result = reportService.updateReportForClient(clientId, reportDTO);
		assertThat(result).isNotNull(); //can be isEqualTo(result) as API call returns updated DTO
		assertThat(result).isInstanceOf(ReportDTO.class);
	}

	@Test
	public void getReportForClientSuccess() throws IllegalStateException {
		ReportDTO result = reportService.getReportForClient(clientId);
		assertThat(result).isNotNull();
		assertThat(result).isInstanceOf(ReportDTO.class);
	}
*/


}
