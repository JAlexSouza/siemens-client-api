package com.siemens_energy.siemens_client_api.controller;

import com.siemens_energy.siemens_client_api.domain.dto.ClientDTO;
import com.siemens_energy.siemens_client_api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getClients(){
        return clientService.getClients();
    }

}
