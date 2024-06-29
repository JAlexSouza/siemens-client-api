package com.siemens_energy.siemens_client_api.service;

import com.siemens_energy.siemens_client_api.domain.dto.ClientDTO;
import com.siemens_energy.siemens_client_api.domain.entity.Address;
import com.siemens_energy.siemens_client_api.domain.entity.Client;
import com.siemens_energy.siemens_client_api.domain.mapper.AddressMapper;
import com.siemens_energy.siemens_client_api.domain.mapper.ClientMapper;
import com.siemens_energy.siemens_client_api.repository.AddressRepository;
import com.siemens_energy.siemens_client_api.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private AddressMapper addressMapper;

    public ResponseEntity<List<ClientDTO>> getClients(){
        List<Client> clients = clientRepository.findAll();

        return new ResponseEntity<List<ClientDTO>>(clients.stream().map(clientMapper::convertToClientDTO).toList(), HttpStatus.OK);
    }

    public ResponseEntity<ClientDTO> addClient(ClientDTO clientDTO) {
        Client client = clientMapper.convertToClient(clientDTO);
        addressRepository.save(client.getAddress());
        clientRepository.save(client);

        return new ResponseEntity<ClientDTO>(clientMapper.convertToClientDTO(client), HttpStatus.OK);
    }

    public ResponseEntity<?> removeClient(Long id) {
        try {
            Client client = clientRepository.findById(id).orElseThrow();
            clientRepository.delete(client);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<ClientDTO> alterClient(ClientDTO clientDTO) {
        try {
            Client client = clientRepository.findById(clientDTO.getId()).orElseThrow();
            client.setName(clientDTO.getName());
            clientRepository.save(client);
            return new ResponseEntity<ClientDTO>(clientMapper.convertToClientDTO(client), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<ClientDTO>> getClientsByName(String name) {
        List<Client> clients = clientRepository.findClientsByName(name);
        if(clients.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ClientDTO>>(clients.stream().map(clientMapper::convertToClientDTO).toList(), HttpStatus.OK);
    }

    public ResponseEntity<List<ClientDTO>> getClient(Long id) {
        try {
            Client client = clientRepository.findById(id).orElseThrow();
            return new ResponseEntity<List<ClientDTO>>(List.of(clientMapper.convertToClientDTO(client)), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
