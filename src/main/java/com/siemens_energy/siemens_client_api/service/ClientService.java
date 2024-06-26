package com.siemens_energy.siemens_client_api.service;

import com.siemens_energy.siemens_client_api.domain.dto.ClientDTO;
import com.siemens_energy.siemens_client_api.domain.entity.Client;
import com.siemens_energy.siemens_client_api.domain.mapper.ClientMapper;
import com.siemens_energy.siemens_client_api.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper clientMapper;

    public ResponseEntity<List<ClientDTO>> getClients(){
        List<Client> clients = clientRepository.findAll();

        return new ResponseEntity<List<ClientDTO>>(clients.stream().map(clientMapper::convertToClientDTO).toList(), HttpStatus.OK);
    }
}
