package com.siemens_energy.siemens_client_api.controller;

import com.siemens_energy.siemens_client_api.domain.dto.ClientDTO;
import com.siemens_energy.siemens_client_api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<ClientDTO>> getClients(){
        return clientService.getClients();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<List<ClientDTO>> getClient(@PathVariable Long id){
        return clientService.getClient(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<ClientDTO> addClient(@RequestBody ClientDTO clientDTO){
        return clientService.addClient(clientDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeClient(@PathVariable Long id){
        return clientService.removeClient(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PatchMapping
    public ResponseEntity<ClientDTO> alterClient(@RequestBody ClientDTO clientDTO){
        return clientService.alterClient(clientDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/names")
    public ResponseEntity<List<ClientDTO>> getClientsByName(@RequestParam String name){
        return clientService.getClientsByName(name);
    }



}
