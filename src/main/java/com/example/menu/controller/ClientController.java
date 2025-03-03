package com.example.menu.controller;

import com.example.menu.dto.client.ClientResponseDTO;
import com.example.menu.dto.client.ClientRequestDTO;
import com.example.menu.entity.Client;
import com.example.menu.services.client.CilentService;
import com.example.menu.services.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping ("/createAccount")
    public ResponseEntity<ClientResponseDTO> createClient(@RequestBody ClientRequestDTO data) {
        Client client = clientService.createClient(data);

        ClientResponseDTO res = new ClientResponseDTO(
                client.getId(),
                client.getName(),
                client.getEmail(),
                client.getPhoneNumber()
                );

        return ResponseEntity.ok(res);
    }

    /*@PostMapping ("/login")
    public ResponseEntity<ClientResponseDTO> login(@RequestBody ClientRequestDTO data) {
        Client client = clientService.login(data);
        
    }*/
}
