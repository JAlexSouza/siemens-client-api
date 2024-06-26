package com.siemens_energy.siemens_client_api.domain.mapper;

import com.siemens_energy.siemens_client_api.domain.dto.ClientDTO;
import com.siemens_energy.siemens_client_api.domain.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    @Autowired
    private AddressMapper addressMapper;

    public ClientDTO convertToClientDTO(Client client) {
        return ClientDTO.builder()
                .id(client.getId())
                .name(client.getName())
                .gender(client.getGender())
                .birthDay(client.getBirthDay())
                .address(addressMapper.convertToAddressDTO(client.getAddress()))
                .build();
    }

    public Client convertToClient(ClientDTO clientDTO) {
        return Client.builder()
                .id(clientDTO.getId())
                .name(clientDTO.getName())
                .gender(clientDTO.getGender())
                .birthDay(clientDTO.getBirthDay())
                .address(addressMapper.convertToAddress(clientDTO.getAddress()))
                .build();
    }
}
