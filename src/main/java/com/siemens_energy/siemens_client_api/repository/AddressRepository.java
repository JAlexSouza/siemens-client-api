package com.siemens_energy.siemens_client_api.repository;

import com.siemens_energy.siemens_client_api.domain.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
