package com.example.menu.controller;

import com.example.menu.dto.ClientRequestDTO;
import com.example.menu.entity.Client;
import com.example.menu.repository.ClientRepository;
import com.example.menu.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody ClientRequestDTO data) {
        Client client = clientService.createClient(data);
        return ResponseEntity.ok(client);
    }
}
