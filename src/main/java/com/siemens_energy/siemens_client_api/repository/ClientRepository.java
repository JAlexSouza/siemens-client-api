package com.siemens_energy.siemens_client_api.repository;

import com.siemens_energy.siemens_client_api.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT c FROM Client c WHERE c.name like %:name% ")
    List<Client> findClientsByName(String name);
}
