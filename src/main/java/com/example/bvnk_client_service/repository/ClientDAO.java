package com.example.bvnk_client_service.repository;

import com.example.bvnk_client_service.entity.Client;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


//TODO do a test for this, both integration and JUnit
public interface ClientDAO extends JpaRepository<Client, Long> {

	Page<Client> findAll(Pageable pageable);

	Optional<Client> findById(Long clientId);

	@Modifying
	@Query("update Client c set c.address = null where c.clientId = ?1")
	void deleteAddressByClientId(Long clientId);

	//this can be done from a service, but as an exercise I will do it here
	@Modifying
	@Query("update Client c set c.firstName = :firstName, c.lastName = :lastName where c.clientId = :clientId")
	void updateFirstAndLastName(@Param("clientId") Long clientId, @Param("firstName") String firstName,
								@Param("lastName") String lastName);

	@Query("select avg(extract(year from c.dateOfBirth)) from Client c")
	Double avgYearsClient();

	@Query("select count(c) from Client c")
	Long numberOfClientsInDatabase();

}
