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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping ("/createAccount")
    public ResponseEntity<ClientResponseDTO> createClient(@RequestBody @Valid ClientRequestDTO data) {
        try {
            Client client = clientService.createClient(data);
            ClientResponseDTO res = new ClientResponseDTO(
                    client.getId(),
                    client.getName(),
                    client.getEmail(),
                    client.getPhoneNumber()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(res);
        } catch (Exception e) {
            throw new RuntimeException("");
        }



    }

    @PostMapping("/login")
    public ResponseEntity<ClientResponseDTO> login(@RequestBody @Valid ClientTokenDTO data) {
        try {
            Client client = clientService.login(data);
            ClientResponseDTO res = new ClientResponseDTO(
                    client.getId(),
                    client.getName(),
                    client.getEmail(),
                    client.getPhoneNumber()
            );
            return ResponseEntity.ok(res);
        } catch (RuntimeException e) {
            throw new RuntimeException("Credentials invalidates");
        }
    }

    @GetMapping ("/getAll")
    public List<Client> getAll() {
        return clientService.getAllClient();
    }

    @PutMapping ("/update/{id}")
    public ResponseEntity<ClientResponseDTO> update(@PathVariable Long id, @RequestBody ClientRequestDTO data) {
        try {
            Client client = clientService.updateClient(id, data);
            ClientResponseDTO res = new ClientResponseDTO(
                    client.getId(),
                    client.getName(),
                    client.getEmail(),
                    client.getPhoneNumber()
            );
            return ResponseEntity.ok(res);
        } catch (RuntimeException e) {
            throw new RuntimeException("Client not found");
        }
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            clientService.deleteClient(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
