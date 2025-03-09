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
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
        Client client = clientService.createClient(data);
        ClientResponseDTO res = new ClientResponseDTO(
                client.getId(),
                client.getName(data.name()),
                client.getEmail(),
                client.getPhoneNumber()
                );

        return ResponseEntity.ok(res);
    }

    @PostMapping("/login")
    public ResponseEntity<Client> login(@RequestBody @Valid ClientTokenDTO data) {
        Client client = clientService.login(data);

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping ("/getAll")
    public List<Client> getAll() {
        return clientService.getAllClient();
    }

    @PutMapping ("/update/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody ClientRequestDTO data) {
        try {
            Client updatedClient = clientService.updateClient(id, data);
            return ResponseEntity.ok(updatedClient);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            clientService.deleteClient(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
