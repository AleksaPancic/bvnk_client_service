package com.example.bvnk_client_service.populator.impl;

import com.example.bvnk_client_service.DTO.ReportDTO;
import com.example.bvnk_client_service.entity.Report;
import com.example.bvnk_client_service.populator.Populator;
import org.hibernate.query.sqm.sql.ConversionException;
import org.springframework.stereotype.Component;


@Component
public class ReportPopulator implements Populator {
	@Override
	public void populate(Object source, Object target) throws ConversionException {
		try {
			if (source != null && target != null && source instanceof ReportDTO && target instanceof Report) {
				final ReportDTO sourceReport = (ReportDTO) source;
				((Report) target).setId(sourceReport.getReportId());
				((Report) target).setReportName(sourceReport.getReportName());
				((Report) target).setReportDescription(sourceReport.getReportDescription());
			} else if(source instanceof Report && target instanceof ReportDTO) {
				final Report sourceReport = (Report) source;
                ((ReportDTO) target).setReportId(sourceReport.getId());
                ((ReportDTO) target).setReportName(sourceReport.getReportName());
                ((ReportDTO) target).setReportDescription(sourceReport.getReportDescription());
			}
		} catch (ClassCastException e) {
			throw new IllegalArgumentException("Invalid source or target type", e);
		}
	}
}
