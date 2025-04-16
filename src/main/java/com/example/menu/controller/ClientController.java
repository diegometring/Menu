package com.example.menu.controller;

import com.example.menu.dto.client.ClientResponseDTO;
import com.example.menu.dto.client.ClientRequestDTO;
import com.example.menu.dto.client.ClientTokenDTO;
import com.example.menu.entity.Client;
import com.example.menu.services.client.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping("/createAccount")
    public ResponseEntity<ClientResponseDTO> createClient(@RequestBody @Valid ClientRequestDTO data) {
        Client client = clientService.createClient(data);
        ClientResponseDTO res = new ClientResponseDTO(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @PostMapping("/login")
    public ResponseEntity<ClientResponseDTO> login(@RequestBody @Valid ClientTokenDTO data) {
        Client client = clientService.login(data);
        ClientResponseDTO res = new ClientResponseDTO(client);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ClientResponseDTO>> getAll() {
        List<Client> clients = clientService.getAllClient();
        List<ClientResponseDTO> resList = clients.stream()
                .map(ClientResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resList);
    }

    @GetMapping ("/get/{id}")
    public ResponseEntity<ClientResponseDTO> getById(Long id) {
        Client client = clientService.getById(id);
        ClientResponseDTO res = new ClientResponseDTO(client);
        return ResponseEntity.ok(res);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ClientResponseDTO> update(@PathVariable Long id, @RequestBody ClientRequestDTO data) {
        Client client = clientService.updateClient(id, data);
        ClientResponseDTO res = new ClientResponseDTO(client);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
