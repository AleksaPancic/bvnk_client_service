package com.example.bvnk_client_service.repository;

import com.example.bvnk_client_service.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReportRepository extends JpaRepository<Report, Long> {
}
