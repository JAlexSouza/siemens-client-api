package com.siemens_energy.siemens_client_api.domain.dto;

import com.siemens_energy.siemens_client_api.domain.enums.State;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDTO {
    private Long id;
    private State state;
    private String city;
}
