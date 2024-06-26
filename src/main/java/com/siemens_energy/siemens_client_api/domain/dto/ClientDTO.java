package com.siemens_energy.siemens_client_api.domain.dto;

import com.siemens_energy.siemens_client_api.domain.enums.Gender;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ClientDTO {

    private Long id;
    private String name;
    private Gender gender;
    private LocalDate birthDay;
    private AddressDTO address;
}
