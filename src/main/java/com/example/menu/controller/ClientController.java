package com.example.menu.controller;

import com.example.menu.dto.client.ClientResponseDTO;
import com.example.menu.dto.client.ClientRequestDTO;
import com.example.menu.entity.Client;
import com.example.menu.services.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //@PostMapping
    //public ResponseEntity<String> login(@RequestBody ClientResponseDTO data) {

    //}
}
