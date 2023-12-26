package com.example.bvnk_client_service.repository;

import com.example.bvnk_client_service.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ClientDAO extends JpaRepository<Client, Long> {
	Optional<Client> findById(Long clientId);
}
