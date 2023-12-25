package com.example.bvnk_client_service.populator.impl;

import com.example.bvnk_client_service.DTO.response.ReportResponseData;
import com.example.bvnk_client_service.entity.Report;
import com.example.bvnk_client_service.populator.Populator;
import org.springframework.stereotype.Component;


@Component
public class ReportPopulator implements Populator { //TODO maybe transfer to converter?

	@Override
	public void populate(Object source, Object target) {

		validateTypes(source, target);

		if (source instanceof ReportResponseData && target instanceof Report) {
			populateReportFromResponseData((ReportResponseData) source, (Report) target);
		} else if (source instanceof Report && target instanceof ReportResponseData) {
			populateResponseDataFromReport((Report) source, (ReportResponseData) target);
		}
	}

	private void validateTypes(Object source, Object target) {
		if (source == null || target == null) {
			throw new IllegalArgumentException("test");
		}
	}

	private void populateReportFromResponseData(ReportResponseData source, Report target) {
		target.setId(source.getReportId());
		target.setReportName(source.getReportName());
		target.setReportDescription(source.getReportDescription());
	}

	private void populateResponseDataFromReport(Report source, ReportResponseData target) {
		target.setReportId(source.getId());
		target.setReportName(source.getReportName());
		target.setReportDescription(source.getReportDescription());
	}
}
