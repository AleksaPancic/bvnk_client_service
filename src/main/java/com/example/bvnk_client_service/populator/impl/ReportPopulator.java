package com.example.bvnk_client_service.populator.impl;

import com.example.bvnk_client_service.DTO.response.ReportResponseData;
import com.example.bvnk_client_service.entity.Report;
import com.example.bvnk_client_service.populator.Populator;
import org.hibernate.query.sqm.sql.ConversionException;
import org.springframework.stereotype.Component;


@Component
public class ReportPopulator implements Populator<ReportResponseData, Report> {

	@Override
	public void populate(ReportResponseData source, Report target) throws ConversionException {
		populateReportFromResponseData(source, target);
	}

	private void populateReportFromResponseData(ReportResponseData source, Report target) {
		target.setReportId(source.getReportId());
		target.setReportName(source.getReportName());
		target.setReportDescription(source.getReportDescription());
	}

}
