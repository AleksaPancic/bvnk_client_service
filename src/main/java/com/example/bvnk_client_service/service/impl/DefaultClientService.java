package com.example.bvnk_client_service.service.impl;

import com.example.bvnk_client_service.DTO.ReportDTO;
import com.example.bvnk_client_service.entity.Client;
import com.example.bvnk_client_service.entity.Report;
import com.example.bvnk_client_service.populator.Populator;
import com.example.bvnk_client_service.repository.ClientRepository;
import com.example.bvnk_client_service.repository.ReportRepository;
import com.example.bvnk_client_service.service.ClientService;
import com.example.bvnk_client_service.service.ReportService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DefaultClientService implements ClientService {
	private final ClientRepository clientRepository;
	private final ReportRepository reportRepository;
	private final ReportService reportService;

	private final Populator reportPopulator;

	@Autowired
	public DefaultClientService(ClientRepository clientRepository, ReportRepository reportRepository,
								ReportService reportService, Populator reportPopulator) {
		this.clientRepository = clientRepository;
		this.reportRepository = reportRepository;
		this.reportService = reportService;
		this.reportPopulator = reportPopulator;
	}

	@Transactional
	@Override
	public void addReportToClient() { // TODO Auto
		Client client = new Client();
		clientRepository.save(client);
		Report report = new Report();//testing for now
		reportRepository.save(report);
		reportPopulator.populate(reportService.getReports().stream().findFirst(), report);
		reportRepository.save(report);
		client.setReport(report);
		clientRepository.save(client);
	}

	@Transactional
	@Override
	public void addReportToClientById(final Long id, final ReportDTO reportDTO) { //fokusiraj se posle na ovo da vidis sta zajebava sa kljucevima
		Report report = new Report();
		reportPopulator.populate(reportDTO,report);
		reportRepository.save(report);
		clientRepository.getReferenceById(id).setReport(report);
	}

	@Override
	public Client getClientById(final Long customerId) {
		return clientRepository.getReferenceById(customerId);
	}
}
