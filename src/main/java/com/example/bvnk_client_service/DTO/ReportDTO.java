package com.example.bvnk_client_service.DTO;

public class ReportDTO {

	private Long reportId;
	private String reportName;
	private String reportDescription;
	// Add other fields as needed

	// Constructors, getters, and setters

	public ReportDTO() {
	}

	public ReportDTO(Long reportId, String reportName, String reportDescription) {
		this.reportId = reportId;
		this.reportName = reportName;
		this.reportDescription = reportDescription;
	}

	// Getters and setters
	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getReportDescription() {
		return reportDescription;
	}

	public void setReportDescription(String reportDescription) {
		this.reportDescription = reportDescription;
	}
}
