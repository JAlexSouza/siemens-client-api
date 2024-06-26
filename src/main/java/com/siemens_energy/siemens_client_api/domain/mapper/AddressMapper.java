package com.siemens_energy.siemens_client_api.domain.mapper;

import com.siemens_energy.siemens_client_api.domain.dto.AddressDTO;
import com.siemens_energy.siemens_client_api.domain.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressDTO convertToAddressDTO(Address address){
        return AddressDTO.builder()
                .id(address.getId())
                .state(address.getState())
                .city(address.getCity())
                .build();
    }

    public Address convertToAddress(AddressDTO addressDTO) {
        return Address.builder()
                .id(addressDTO.getId())
                .state(addressDTO.getState())
                .city(addressDTO.getCity())
                .build();
    }
}
